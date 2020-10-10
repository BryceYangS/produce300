package com.kge.produce300.domain.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("candidate")
//@ToString
//@Getter
public class Candidate {

    @MongoId
    private Object _id;
    private String name;
    private String party;
    private String huboId;
    private String gender;
    private String age;
    private String sign;
    private String image;
    private String sggCode;
    private String sggName;
    private String sido;

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public String getHuboId() {
        return huboId;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getSign() {
        return sign;
    }

    public String getImage() {
        return image;
    }

    public String getSggCode() {
        return sggCode;
    }

    public String getSggName() {
        return sggName;
    }

    public String getSido() {
        return sido;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", party='" + party + '\'' +
                ", huboId='" + huboId + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", sign='" + sign + '\'' +
                ", image='" + image + '\'' +
                ", sggCode='" + sggCode + '\'' +
                ", sggName='" + sggName + '\'' +
                ", sido='" + sido + '\'' +
                '}';
    }
}
