package com.kge.produce300.service;

import com.kge.produce300.domain.entity.Candidate;
import com.kge.produce300.domain.repository.CandidateRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class Produce300RepositoryTest {

    @Autowired
    CandidateRepository CANDIDATE_REPO;

    @Test
    void 후보자조회(){
        List<Candidate> candidates = CANDIDATE_REPO.findAll();
        assertThat(candidates.size()).isEqualTo(1101);
        System.out.println(candidates.get(0));

    }


}