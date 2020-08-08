package com.kge.produce300.service;

import com.kge.produce300.domain.dto.CandidateDTO;
import com.kge.produce300.domain.entity.AdministrativeDong;
import com.kge.produce300.domain.entity.Elected;

import java.util.List;
import java.util.Map;

public interface Produce300Service {

    // 기본데이터
    Map<String, Object> retrieveBaseData() throws Exception;

    // 선거일 기준 선거구별 행정동 geojson
    List<AdministrativeDong> retrieveAdministrativeDongs(String electionCode) throws Exception;

    // 선거일 기준 당선인 목록
    List<Elected> retrieveElectedResult(String electionCode) throws Exception;
    
    // 선거일 기준 선거구 후보 목록
    List<CandidateDTO> retrieveCandidates(String sggCode) throws Exception;
}
