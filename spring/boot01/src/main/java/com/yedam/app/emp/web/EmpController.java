package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;

import com.yedam.app.emp.service.EmpService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor /* final 선언되어있는 필드를 기반으로해서 생성자를 강제로 만든다. 별도의 Autowired 필요없음*/
public class EmpController {
	private final EmpService empService;
}
