package com.jffcm.mybatis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jffcm.mybatis.mapper.SleepRecordMapper;
import com.jffcm.mybatis.pojo.SleepRecord;
import com.jffcm.mybatis.service.SleepRecordService;

import jakarta.annotation.Resource;

@Service("sleepRecordServiceImpl")
public class SleepRecordServiceImpl implements SleepRecordService {
	
	@Resource(name = "sleepRecordMapper")
	private SleepRecordMapper mapper;

	@Override
	public void insertSleepRecord(SleepRecord record) {
		mapper.insertSleepRecord(record);
	}

	@Override
	public SleepRecord selectSleepRecordById(Integer id) {
		return mapper.selectSleepRecordById(id);
	}

	@Override
	public List<SleepRecord> selectAllSleepRecords() {
		return mapper.selectAllSleepRecords();
	}

	@Override
	public void deleteSleepRecord(Integer id) {
		mapper.deleteSleepRecord(id);
	}

	@Override
	public void updateSleepRecord(SleepRecord record) {
		mapper.updateSleepRecord(record);
	}
}
