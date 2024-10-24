package com.yedam.app.common.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class WebControllerAdvice {
	@ExceptionHandler(NoHandlerFoundException.class) //1. 지정된 예외발생시, 스플이내장 핸들러말고 사용자가 등록한 핸들러가 실행되게금 함. 
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handler404(NoHandlerFoundException e) {
		return "error/notFount";
	}
	
	@ModelAttribute("contextPath") //2. 전역변수 선언 (모델선언을하지않고 직접담아버리는 것) context-path 처리를 위한 어노테이션
	public String contextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
}
