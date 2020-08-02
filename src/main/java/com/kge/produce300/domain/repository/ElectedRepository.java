package com.kge.produce300.domain.repository;

import com.kge.produce300.domain.entity.Elected;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ElectedRepository extends MongoRepository<Elected, String> {
    public List<Elected> findByElectionCode(String electionCode);
}
