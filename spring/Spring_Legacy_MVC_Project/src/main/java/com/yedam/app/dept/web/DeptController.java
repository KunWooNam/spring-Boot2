package com.yedam.app.dept.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller // Bean 등록, Web과 관련
//사용자의 요청(URI + Method) + 기능(Service) + 화면(View)
public class DeptController {
	private DeptService deptService;
	
	@Autowired //생성자 주입
	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	// 전체조회 : GET
	@GetMapping("deptList")
	public String deptAllList(Model model) {
		List<DeptVO> list = deptService.getDeptList();
		// 조회 후 페이지만 보여줄거라 UserVO객체는 필요없음,페이지에 데이터를 전달해야하기 때문에 Model 객체는 필요(req,res 두개의 용도에 사용하나 보통 페이지에 데이터전달할 때 많이 사용함)
		// 페이지에 데이터를 전달 => Model
		model.addAttribute("depts", list);
		
		return "list"; //화면(View) => /WEB-INF/views/ + list + .jsp
		//경로 생성 => ViewResolver
	}
	
	@GetMapping("depts")
	public String redirectAllList() {
		return "redirect:deptList";
	}
}