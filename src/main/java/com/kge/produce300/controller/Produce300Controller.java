package com.kge.produce300.controller;

import com.google.gson.JsonObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Produce300Controller {

    @ApiOperation(value = "기초데이터", httpMethod = "get", notes = "행정동,당선인 데이터")
    @GetMapping("/api/data")
    public ResponseEntity<Object> getData() throws Exception{
        JsonObject result = new JsonObject();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
