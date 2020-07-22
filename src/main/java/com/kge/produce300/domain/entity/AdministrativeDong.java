package com.kge.produce300.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "hjd")
@ToString(exclude = "_id")
@AllArgsConstructor
@NoArgsConstructor
public class AdministrativeDong {

    @Id
    private String _id;
    private String type;
    private Geometry geometry;
    private Properties properties;

}
