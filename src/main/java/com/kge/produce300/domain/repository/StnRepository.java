package com.kge.produce300.domain.repository;

import com.kge.produce300.domain.entity.Stn;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StnRepository extends MongoRepository<Stn, String> {

}
