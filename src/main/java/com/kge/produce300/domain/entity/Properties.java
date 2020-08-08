package com.kge.produce300.domain.entity;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Properties implements Serializable {

    private String sggCode;
    private String sggName;
    private String cityName;
    private String cityCode;
    private String electionCode;

}
