package com.kge.produce300.service.impl;

import com.kge.produce300.domain.dto.CandidateDTO;
import com.kge.produce300.domain.entity.AdministrativeDong;
import com.kge.produce300.domain.entity.Candidate;
import com.kge.produce300.domain.entity.Elected;
import com.kge.produce300.domain.repository.AdministrativeDongRepository;
import com.kge.produce300.domain.repository.CandidateRepository;
import com.kge.produce300.domain.repository.ElectedRepository;
import com.kge.produce300.service.Produce300Service;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service("produce300Service")
@RequiredArgsConstructor
public class Produce300ServiceImpl implements Produce300Service {

    private final AdministrativeDongRepository ADMIN_DONG_REPO;
    private final ElectedRepository ELECTED_REPO;
    private final CandidateRepository CANDIDATE_REPO;

    @Override
    public List<AdministrativeDong> retrieveAdministrativeDongs(String electionCode) throws Exception {
        return ADMIN_DONG_REPO.findByPropertiesElectionCode(electionCode);
    }

    @Override
    public List<Elected> retrieveElectedResult(String electionCode) throws Exception {
        return ELECTED_REPO.findByElectionCode(electionCode);
    }

    @Override
    public List<CandidateDTO> retrieveCandidates(String sggCode) throws Exception {
        List<CandidateDTO> candidatesWithVoteRate = new ArrayList<>();
        List<Candidate> candidates = CANDIDATE_REPO.findBySggCode(sggCode);

        String URL = "http://info.nec.go.kr/electioninfo/electionInfo_report.xhtml";
        Document doc = Jsoup.connect(URL)
                        .data("electionId", "0020200415")
                        .data("requestURI", "/WEB-INF/jsp/electioninfo/0020200415/vc/vccp09.jsp")
                        .data("topMenuId", "VC")
                        .data("secondMenuId", "VCCP09")
                        .data("menuId", "VCCP09")
                        .data("statementId", "VCCP09_#2")
                        .data("electionCode", "2")
                        .data("cityCode", sggCode.substring(1, 3)+"00")
                        .data("sggCityCode", sggCode)
                        .data("townCode", "-1")
                        .data("sggTownCode", "0")
                        .data("x", "25")
                        .data("y", "14")
                        .get();
        List<Node> row = doc.select("#table01 > tbody > tr").get(1).childNodes();
        List<Node> voteRateColumns = IntStream.range(0, row.size()).filter(i -> i%2 == 1).mapToObj(i -> row.get(i)).collect(Collectors.toList());

        for(int i = 0; i < candidates.size(); i++){
            String voteRate = voteRateColumns.get(i + 4).childNode(2).toString().replaceAll("[\\(\\)]", "");
            String openVoteRate = voteRateColumns.get(voteRateColumns.size() - 1).childNode(0).toString();

            CandidateDTO cnadidateDto = CandidateDTO.builder()
                    .age(candidates.get(i).getAge())
                    .name(candidates.get(i).getName())
                    .party(candidates.get(i).getParty())
                    .huboId(candidates.get(i).getHuboId())
                    .gender(candidates.get(i).getGender())
                    .sign(candidates.get(i).getSign())
                    .image(candidates.get(i).getImage())
                    .openVoteRate(openVoteRate)
                    .voteRate(voteRate)
                    .build();

            candidatesWithVoteRate.add(cnadidateDto);
        }

        return candidatesWithVoteRate;
    }
}
