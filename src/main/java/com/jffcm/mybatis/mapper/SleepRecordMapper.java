package com.jffcm.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.jffcm.mybatis.pojo.SleepRecord;

@Mapper
@Component("sleepRecordMapper")
public interface SleepRecordMapper {
	
	@Insert("INSERT INTO sleep_record (date, start_time, end_time) VALUES (#{date}, #{startTime}, #{endTime})")
	void insertSleepRecord(SleepRecord record);
	
	@Select("SELECT * FROM sleep_record WHERE id = #{id}")
	@Results({
		 @Result(property = "id", column = "id"),
		 @Result(property = "date", column = "date"),
		 @Result(property = "startTime", column = "start_time"),
		 @Result(property = "endTime", column = "end_time"),
		 @Result(property = "duration", column = "duration")
	})
	SleepRecord selectSleepRecordById(@Param("id") Integer id);
	
	@Select("SELECT * FROM sleep_record")
	@Results({
	    @Result(property = "id", column = "id"),
	    @Result(property = "date", column = "date"),
	    @Result(property = "startTime", column = "start_time"),
	    @Result(property = "endTime", column = "end_time"),
	    @Result(property = "duration", column = "duration")
	})
	List<SleepRecord> selectAllSleepRecords();
	
	@Delete("DELETE FROM sleep_record WHERE id = #{id}")
	void deleteSleepRecord(@Param("id") Integer id);
	
	@Update("""
				UPDATE sleep_record
				SET date = #{date}, start_time = #{startTime}, end_time = #{endTime}
				WHERE id = #{id}
			""")
	void updateSleepRecord(SleepRecord record);
	
}
