package com.kge.produce300.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Properties {

    private String sggCode;
    private String sggName;
    private String cityName;
    private String cityCode;
    private String electionCode;

}
