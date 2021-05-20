package com.kge.produce300.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.kge.produce300.domain.dto.CandidateDTO;
import com.kge.produce300.service.Produce300Service;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Produce300Controller {

	private final Produce300Service produce300Service;

	@ApiOperation(value = "기본 데이터", httpMethod = "GET", notes = "행정동,당선인 데이터")
	@GetMapping("/api/data")
	public ResponseEntity<Object> getData() throws Exception {
		CacheControl cacheControl = CacheControl.maxAge(9999, TimeUnit.SECONDS);
		return ResponseEntity.ok()
			.cacheControl(cacheControl)
			.body(produce300Service.retrieveBaseData());
	}

	@ApiOperation(value = "21대 후보자 정보", httpMethod = "GET", notes = "21대 후보자 정보")
	@GetMapping("/api/candidate")
	public ResponseEntity<Object> getCandidateData(@RequestParam String sggCode) throws Exception {

		Map<String, Object> result = new HashMap<>();
		List<CandidateDTO> candidates = produce300Service.retrieveCandidates(sggCode);
		result.put("candidates", candidates);

		CacheControl cacheControl = CacheControl.maxAge(99999, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK)
			.cacheControl(cacheControl)
			.body(result);
	}

	@ApiOperation(value = "후보자 이미지", httpMethod = "GET", notes = "선관위 이미지 stream 변환")
	@GetMapping(value = "/api/candidateImg", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] convertCandidateImg(@RequestParam String url) throws IOException {
		URL urlObject = new URL(url);
		return IOUtils.toByteArray(urlObject.openStream());
	}

	@ApiOperation(value = "후보자 전체 데이터", httpMethod = "GET", notes = "후보자 전체 데이터")
	@GetMapping("/api/allCandidate")
	public ResponseEntity<Object> getAllCandidateData() throws Exception {

		Map<String, Object> result = new HashMap<>();
		List<CandidateDTO> data = produce300Service.getAllCandidateData();
		result.put("data", data);

		CacheControl cacheControl = CacheControl.maxAge(99999, TimeUnit.SECONDS);

		return ResponseEntity.status(HttpStatus.OK)
			.cacheControl(cacheControl)
			.body(result);
	}

	// TODO
	@ApiOperation(value = "투표소 목록", httpMethod = "GET", notes = "투표소 목록")
	@GetMapping("/api/stns")
	public ResponseEntity<Object> getStns(@RequestBody Map<String, Object> param) throws Exception {
		JsonObject result = new JsonObject();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// TODO
	@ApiOperation(value = "투표율", httpMethod = "GET", notes = "투표율")
	@GetMapping("/api/voteRate")
	public ResponseEntity<Object> getVoteRate() {
		JsonObject result = new JsonObject();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
