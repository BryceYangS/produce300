package com.kge.produce300.controller;

import com.google.gson.JsonObject;
import com.kge.produce300.domain.dto.CandidateDTO;
import com.kge.produce300.service.Produce300Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Produce300Controller {

    @Resource(name = "produce300Service")
    private Produce300Service produce300Service;


    @ApiOperation(value = "기본 데이터", httpMethod = "GET", notes = "행정동,당선인 데이터")
    @GetMapping("/api/data")
    public ResponseEntity<Object> getData() throws Exception {
        return new ResponseEntity<>(produce300Service.retrieveBaseData(), HttpStatus.OK);
    }


    @ApiOperation(value = "21대 후보자 정보", httpMethod = "GET", notes = "21대 후보자 정보")
    @GetMapping("/api/candidate")
    public ResponseEntity<Object> getCandidateData(@RequestParam String sggCode) throws Exception {
        Map<String, Object> result = new HashMap<>();
        List<CandidateDTO> candidates = produce300Service.retrieveCandidates(sggCode);
        result.put("candidates", candidates);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "후보자 이미지", httpMethod = "GET", notes = "선관위 이미지 stream 변환")
    @GetMapping("/api/candidateImg")
    public ResponseEntity<Object> convertCandidateImg(@RequestParam String url) {
        JsonObject result = new JsonObject();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "후보자 전체 데이터", httpMethod = "GET", notes = "후보자 전체 데이터")
    @GetMapping("/api/allCandidate")
    public ResponseEntity<Object> getAllCandidateData() {
        JsonObject result = new JsonObject();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "투표소 목록", httpMethod = "GET", notes = "투표소 목록")
    @GetMapping("/api/stns")
    public ResponseEntity<Object> getStns(@RequestBody Map<String, Object> param) {
        JsonObject result = new JsonObject();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "투표율", httpMethod = "GET", notes = "투표율")
    @GetMapping("/api/voteRate")
    public ResponseEntity<Object> getVoteRate() {
        JsonObject result = new JsonObject();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
