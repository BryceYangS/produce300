package com.kge.produce300.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Geometry {

    private String type;
    private List<List<List<List<Double>>>> coordinates;

}
