package com.kge.produce300.domain.repository;

import com.kge.produce300.domain.entity.AdministrativeDong;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AdministrativeDongRepository extends MongoRepository<AdministrativeDong, String> {

    @Query("{ 'properties.electionCode' : ?0 }}")
    public List<AdministrativeDong> findByPropertiesElectionCode(String electionCode);

//    @Query(value = "{ 'userId' : ?0, 'questions.questionID' : ?1 }", fields = "{ 'questions.questionID' : 1 }")
//    List<PracticeQuestion> findByUserIdAndQuestionsQuestionID(int userId, int questionID);

}
