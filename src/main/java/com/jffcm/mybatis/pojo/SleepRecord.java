package com.jffcm.mybatis.pojo;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonSetter;

public class SleepRecord implements Serializable {
	
	private static final long serialVersionUID = 4146898309714254338L;
	
	private Integer id;
	private LocalDate date;		
	private LocalTime startTime;	
	private LocalTime endTime;
	private Integer duration;
	
	public Integer getId() {	
		return id;	
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	
	@JsonSetter("start_time")
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
		updateDuration();
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}
	
	@JsonSetter("end_time")
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
		updateDuration();
	}
	
	public Integer getDuration() {
		return duration;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "SleepRecord [id=" + id + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", duration=" + duration + "]";
	}
	
	public void updateDuration() {
		if (startTime != null && endTime != null) {
			duration = (int) Duration.between(startTime, endTime)
					.toHours();
		}
	}
}
