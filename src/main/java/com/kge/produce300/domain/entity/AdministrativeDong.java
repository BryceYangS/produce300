package com.kge.produce300.domain.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "hjd")
@ToString(exclude = "_id")
@Getter
public class AdministrativeDong {

    @MongoId
    private String _id;
    private String type;
    private Geometry geometry;
    private Properties properties;

}
