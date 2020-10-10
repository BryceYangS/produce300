package com.kge.produce300.domain.repository;

import com.kge.produce300.domain.entity.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CandidateRepository extends MongoRepository<Candidate, String> {
    @Query(value="{ 'sggCode' : ?0 }", fields="{ 'sggCode' : 0, '_id' : 0 }", sort = "{'_id': 1}")
    public List<Candidate> findBySggCode(String sggCode);

//    @Override
//    @Query(fields = "{'sido': 1, 'name': 1, 'sggCode': 1, 'sggName': 1}")
//    public List<Candidate> findAll();

}
