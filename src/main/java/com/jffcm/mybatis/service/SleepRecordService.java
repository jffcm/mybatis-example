package com.jffcm.mybatis.service;

import java.util.List;

import com.jffcm.mybatis.pojo.SleepRecord;

public interface SleepRecordService {
	void insertSleepRecord(SleepRecord record);	
	SleepRecord selectSleepRecordById(Integer id);	
	List<SleepRecord> selectAllSleepRecords();	
	void deleteSleepRecord(Integer id);
	void updateSleepRecord(SleepRecord record);
}
