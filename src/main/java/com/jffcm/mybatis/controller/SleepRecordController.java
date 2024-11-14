package com.jffcm.mybatis.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jffcm.mybatis.pojo.SleepRecord;
import com.jffcm.mybatis.service.SleepRecordService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping(path = "/api/v1/records")
public class SleepRecordController {

	@Resource(name = "sleepRecordServiceImpl")
	public SleepRecordService service;
	
	@PostMapping
	public ResponseEntity<Void> insertSleepRecord(@RequestBody SleepRecord record) {
		service.insertSleepRecord(record);		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<SleepRecord>> selectAllSleepRecords() {
		List<SleepRecord> records = service.selectAllSleepRecords();
		return new ResponseEntity<List<SleepRecord>>(records, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SleepRecord> selectSleepRecordById(@PathVariable("id") Integer id) {
		SleepRecord record = service.selectSleepRecordById(id);
		return new ResponseEntity<SleepRecord>(record, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Void> updateSleepRecord(@RequestBody SleepRecord record) {
		service.updateSleepRecord(record);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSleepRecord(@PathVariable("id") Integer id) {
		service.deleteSleepRecord(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
