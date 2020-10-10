package com.kge.produce300.service.impl;

import com.kge.produce300.domain.dto.CandidateDTO;
import com.kge.produce300.service.Produce300Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Produce300ServiceImplTest {


    @Autowired
    Produce300Service produce300Service;


    @Test
    void getAllCandidateData() throws Exception {
        try {
            List<CandidateDTO> allCandidateData = produce300Service.getAllCandidateData();
            assertThat(allCandidateData.size()).isEqualTo(1101);
            System.out.println(allCandidateData.get(0));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}