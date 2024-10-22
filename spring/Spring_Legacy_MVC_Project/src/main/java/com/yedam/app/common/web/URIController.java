package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Bean 등록, Web과 관련된 부분
public class URIController {
	
	//@RequestMapping(path="test", method=RequestMethod.GET)
	@GetMapping("test") //위 코드와 같은 기능
	@ResponseBody // AJAX용 어노테이션
	public String urlGetTest(String keyword){
		return "Server Response ; Get Method\n Select - " + keyword;
	}
	
	//@RequestMapping(path="test", method=RequestMethod.POST) //같은경로는 등록하면 충돌발생. method 다르면 충돌안남.
	@PostMapping("test") //위 코드와 같은 기능
	@ResponseBody
	public String urlPostTest(String keyword){
		return "Server Response ; Post Method\n Select - " + keyword;
	}
}
