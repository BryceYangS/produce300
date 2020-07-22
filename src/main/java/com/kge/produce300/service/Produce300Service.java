package com.kge.produce300.service;

import com.kge.produce300.domain.entity.AdministrativeDong;

import java.util.List;

public interface Produce300Service {

    // 선거일 기준 선거구별 행정동 geojson
    List<AdministrativeDong> retrieveAdministrativeDongs(String electionCode) throws Exception;
    // 선거일 기준 당선인 목록
    
    

}
