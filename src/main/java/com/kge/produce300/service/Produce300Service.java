package com.kge.produce300.service;

import static java.util.stream.Collectors.*;

import com.kge.produce300.domain.dto.CandidateDTO;
import com.kge.produce300.domain.entity.AdministrativeDong;
import com.kge.produce300.domain.entity.Candidate;
import com.kge.produce300.domain.entity.Elected;
import com.kge.produce300.domain.repository.AdministrativeDongRepository;
import com.kge.produce300.domain.repository.CandidateRepository;
import com.kge.produce300.domain.repository.ElectedRepository;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class Produce300Service {

    private final AdministrativeDongRepository ADMIN_DONG_REPO;
    private final ElectedRepository ELECTED_REPO;
    private final CandidateRepository CANDIDATE_REPO;

    @Cacheable(value ="base-data", key = "'data'")
    public Map<String, Object> retrieveBaseData() throws Exception {
        Map<String, Object> result = new HashMap<>();

        //20대 선거구별 행정동 geojson
        Map<String, Object> geoJson20 = new HashMap<>();
        List<AdministrativeDong> hjd20 = retrieveAdministrativeDongs("20160413");
        geoJson20.put("type", "FeatureCollection");
        geoJson20.put("features", hjd20);
        result.put("geoJson20", geoJson20);

        //21대 선거구별 행정동 geojson
        List<AdministrativeDong> hjd21 = retrieveAdministrativeDongs("20200415");
        Map<String, Object> geoJson21 = new HashMap<>();
        geoJson21.put("type", "FeatureCollection");
        geoJson21.put("features", hjd21);
        result.put("geoJson21", geoJson21);

        //20대 당선인
        List<Elected> elected20 = retrieveElectedResult("20160413");
        result.put("elected20", elected20);

        //21대 당선인
        List<Elected> elected21 = retrieveElectedResult("20200415");
        result.put("elected21", elected21);
        return result;
    }

    private List<AdministrativeDong> retrieveAdministrativeDongs(String electionCode) throws Exception {
        return ADMIN_DONG_REPO.findByPropertiesElectionCode(electionCode);
    }

    private List<Elected> retrieveElectedResult(String electionCode) throws Exception {
        return ELECTED_REPO.findByElectionCode(electionCode);
    }

    @Cacheable(value = "candidates", key = "#sggCode")
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
        List<Node> voteRateColumns = IntStream.range(0, row.size()).filter(i -> i%2 == 1).mapToObj(i -> row.get(i)).collect(toList());

        for(int i = 0; i < candidates.size(); i++){
            String voteRate = voteRateColumns.get(i + 4).childNode(2).toString().replaceAll("[\\(\\)]", "");
            String openVoteRate = voteRateColumns.get(voteRateColumns.size() - 1).childNode(0).toString();

            CandidateDTO cnadidateDto = new CandidateDTO.builder()
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

    public List<CandidateDTO> getAllCandidateData() throws Exception {

        List<Candidate> candidates = CANDIDATE_REPO.findAll();

        List<CandidateDTO> candidateDtos = candidates.stream()
                .map(candidate -> {
                    CandidateDTO candidateDTO = new CandidateDTO.CandidateDTOBuilder()
                            .sido(candidate.getSido())
                            .name(candidate.getName())
                            .sggCode(candidate.getSggCode())
                            .sggName(candidate.getSggName())
                            .build();
                    return candidateDTO;
                }).collect(toList());

        return candidateDtos;
    }

    public String getStns(Map<String, Object> param) throws Exception {
        return null;
    }

    public Map<String, Object> getVoteRate() throws Exception {
        return null;
    }

}
