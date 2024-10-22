package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParamController {
	// Content-type : application/x-www-form-urlencoded
	// QueryString(질의문자열) : key=value&key=value...
	// Method : 상관없음
	// => GET(검색, 단 건 조회), <form/> 사용 시 이용됨
	
	// QueryString => 커맨드 객체 (어노테이션X, 객체)
	@RequestMapping(path="comobj", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String commandObject(UserVO userVO) {
		String result = "";
		result += "Path : /comobj \n";
		result += "\t user_id : " + userVO.getUserId();
		result += "\t username : " + userVO.getUsername();
		result += "\t comments : " + userVO.getComments();
		return result;
	}
	
	// QueryString => @RequestParam : 기본타입, 단일값
	@RequestMapping(path = "reqparam", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String requestParam (String userName, @RequestParam String userId, @RequestParam(name = "msg", defaultValue="No Commnets", required = true) String comments) {
		String result = "";
		result += "Path : /comobj \n";
		result += "\t user_id : " + userId;
		result += "\t username : " + userName;
		result += "\t comments : " + comments;
		return result;
	}
	
	// Content-type : application/json
	// JSON (Javascript Object Notation) : 객체 or 배열 => JSON은 단일값 처리 불가
	// 객체형식 =>{ "name" : "value", "name" : "value", ...} 
	// 배열형식 =>[ {}, {} , ...] 		
	// Method 
	// => AJAX , AJAX를 제외하고 JSON을 사용하는 경우는 DB밖에 없을 것.
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody UserVO userVO) {
		String result = "";
		result += "Path : /resBody \n";
		result += "\t user_id : " + userVO.getUserId();
		result += "\t username : " + userVO.getUsername();
		result += "\t comments : " + userVO.getComments();
		return result;
	}
	
	@PostMapping("jsonList")
	@ResponseBody
	public String requestBodyList(@RequestBody List<UserVO> userList) { //List 타입은 중괄호로 요청되는 데이터를 처리할 수 없음.
		String result = "Path : /jsonList \n";
		for(UserVO userVO : userList) {
			result += "\t user_id : " + userVO.getUserId();
			result += "\t username : " + userVO.getUsername();
			result += "\t comments : " + userVO.getComments();
		}
		return result;
	}
	
	// Content-type과 상관없음
	// Method도 상관없음
	// 단, 단일값만 처리가능
	// => 다른 Content-type에 추가적인 값이 필요한 경우
	@RequestMapping("path/{id}") //중괄호는 경로에 사용되지 않는 특수 문자, 따라서 PathVariable에 사용된 변수라고 인식함. / 데이터가 없으면? 경로미완성이므로 400번 에러발생
	@ResponseBody //"path/{id}/some" 이런식으로 중간에 변수를 써버리면 이상한 데이터가 넘어갈 수 있음을 유의
	public String pathVariable(@PathVariable String id) { //List 타입은 중괄호로 요청되는 데이터를 처리할 수 없음.
		String result = "";
			result += "path : /path/{id} \n";
			result += "\t id : " + id;
		return result;
	}
}