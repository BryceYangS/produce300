package com.kge.produce300.domain.entity;


import lombok.Getter;

import java.util.List;

@Getter
public class Geometry {

    private String type;
    // Mongo DB 상에서는 [126.96677353769867, 37.565794364324915] 인데
    // [126.96677353769867],[37.565794364324915]   ---> 이렇게 출력되는데... 어떻게 고쳐야할까??
    private List<List<List<List<Double>>>> coordinates;

}
