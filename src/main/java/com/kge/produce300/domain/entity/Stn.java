package com.kge.produce300.domain.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document("stn")
public class Stn {

    @MongoId
    private Object _id;
    private String stnName;
    private String votePlace;
    private String address;
    private List<String> facility;
    private String sido;
    private Geometry location;

    public Object get_id() {
        return _id;
    }

    public String getStnName() {
        return stnName;
    }

    public String getVotePlace() {
        return votePlace;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getFacility() {
        return facility;
    }

    public String getSido() {
        return sido;
    }

    public Geometry getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Stn{" +
                "stnName='" + stnName + '\'' +
                ", votePlace='" + votePlace + '\'' +
                ", address='" + address + '\'' +
                ", facility=" + facility +
                ", sido='" + sido + '\'' +
                ", location=" + location +
                '}';
    }
}
