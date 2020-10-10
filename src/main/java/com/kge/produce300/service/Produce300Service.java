package com.kge.produce300.service;

import com.kge.produce300.domain.dto.CandidateDTO;
import com.kge.produce300.domain.entity.AdministrativeDong;
import com.kge.produce300.domain.entity.Elected;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public interface Produce300Service {

    // 기본데이터
    public Map<String, Object> retrieveBaseData() throws Exception;

    // 선거일 기준 선거구 후보 목록
    public List<CandidateDTO> retrieveCandidates(String sggCode) throws Exception;

    /**
     * /api/allCandidate
     * 후보자 전체 데이터
     */
    public List<CandidateDTO> getAllCandidateData() throws Exception;

    /**
     * /api/stns
     * 투표소 목록 반환
     */
    public String getStns(Map<String, Object> param) throws Exception;

    /**
     * /api/voteRate
     * 투표율
     */
    public Map<String, Object> getVoteRate() throws Exception;
}
