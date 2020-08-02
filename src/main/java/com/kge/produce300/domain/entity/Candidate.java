package com.kge.produce300.domain.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("candidate")
@ToString
@Getter
public class Candidate {

    @MongoId
    private long _id;
    private String name;
    private String party;
    private String huboId;
    private String gender;
    private String age;
    private String sign;
    private String image;
    private String sggCode;

}
