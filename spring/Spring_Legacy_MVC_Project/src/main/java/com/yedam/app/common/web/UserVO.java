package com.yedam.app.common.web;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserVO {
	private String userId;
	private String username;
	private String comments;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // => SimpledateFormat
	private Date joinDate; // 자바 내장함수의 날짜기본형태  => yy/MM/dd, <input type="date">의 데이터는 yyyy-MM-dd 형태로 요청됨.
}
