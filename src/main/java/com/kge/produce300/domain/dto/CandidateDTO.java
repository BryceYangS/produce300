package com.kge.produce300.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CandidateDTO {

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
