package com.kge.produce300.domain.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

//@Getter
//@Builder
public class CandidateDTO implements Serializable {

    private String name;
    private String party;
    private String huboId;
    private String gender;
    private String age;
    private String sign;
    private String image;
    private String voteRate;
    private String openVoteRate;
    private String sido;
    private String sggCode;
    private String sggName;

    public static class Builder {
        private String name;
        private String party;
        private String huboId;
        private String gender;
        private String age;
        private String sign;
        private String image;
        private String voteRate;
        private String openVoteRate;
        private String sido;
        private String sggCode;
        private String sggName;

        public Builder age(String value){
            age = value;
            return this;
        }

        public Builder name(String value){
            name = value;
            return this;
        }
        public Builder party(String value){
            party = value;
            return this;
        }
        public Builder huboId(String value){
            huboId = value;
            return this;
        }
        public Builder gender(String value){
            gender = value;
            return this;
        }
        public Builder sign(String value){
            sign = value;
            return this;
        }
        public Builder image(String value){
            image = value;
            return this;
        }
        public Builder openVoteRate(String value){
            openVoteRate = value;
            return this;
        }
        public Builder voteRate(String value){
            voteRate = value;
            return this;
        }

        public Builder sido(String value){
            sido = value;
            return this;
        }

        public Builder sggCode(String value){
            sggCode = value;
            return this;
        }

        public Builder sggName(String value){
            sggName = value;
            return this;
        }

        public CandidateDTO build(){
            return new CandidateDTO(this);
        }
    }


    private CandidateDTO(Builder builder){
        name = builder.name;
        party = builder.party;
        huboId = builder.huboId;
        gender = builder.gender;
        age = builder.age;
        sign = builder.sign;
        image = builder.image;
        voteRate = builder.voteRate;
        openVoteRate = builder.openVoteRate;
        sido = builder.sido;
        sggCode = builder.sggCode;
        sggName = builder.sggName;
    }


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

    public String getVoteRate() {
        return voteRate;
    }

    public String getOpenVoteRate() {
        return openVoteRate;
    }

    public String getSido() {
        return sido;
    }

    public String getSggCode() {
        return sggCode;
    }

    public String getSggName() {
        return sggName;
    }

    @Override
    public String toString() {
        return "CandidateDTO{" +
                "name='" + name + '\'' +
                ", party='" + party + '\'' +
                ", huboId='" + huboId + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", sign='" + sign + '\'' +
                ", image='" + image + '\'' +
                ", voteRate='" + voteRate + '\'' +
                ", openVoteRate='" + openVoteRate + '\'' +
                ", sido='" + sido + '\'' +
                ", sggCode='" + sggCode + '\'' +
                ", sggName='" + sggName + '\'' +
                '}';
    }
}
