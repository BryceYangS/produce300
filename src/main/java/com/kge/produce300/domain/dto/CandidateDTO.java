package com.kge.produce300.domain.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
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

}
