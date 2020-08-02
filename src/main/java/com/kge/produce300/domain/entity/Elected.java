package com.kge.produce300.domain.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "elected")
@ToString(exclude = "_id")
@Getter
public class Elected {

    @MongoId
    private String _id;
    @Indexed
    private String electionCode;
    private String sggCode;
    private String sggName;
    private String cityName;
    private String cityCode;
    private String name;
    private String party;
    private String number;
}
