package com.yedam.app.emp.web;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.EmpVO;
import com.yedam.app.emp.service.EmpService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor /* final 선언되어있는 필드를 기반으로해서 생성자를 강제로 만든다. 별도의 Autowired 필요없음. 
							생성자 주입의 변경 여부를 고려 => 추가 생성자는 없어야 함 */

public class EmpController {
	//제공하고자 하는 서비스
	private final EmpService empService;
	
	//일반적으로 7개 필요했음
	//GET : 조회, 빈페이지
	//POST : 데이터 조작(등록, 수정, 삭제)
	
	//전체조회 : GET
	@GetMapping("empList") // 사용자의 요청(URI + Method)
	public String empList(Model model) { // Model이 아닌 요청,응답을 따로 사용하고싶으면 따로 선언할 수 있음. EX) HttpRequest req, HttpResponse res
		//기능 수행
		List<EmpVO> list = empService.empList();
		// => 페이지에 전달할 데이터 담기
		model.addAttribute("emps", list);
		return "emp/list"; //데이터를 출력할 페이지
		//classpath:/templates/emp/list.html
	}
	
	//단건조회 : GET => QueryString(RequestParam) + 객체 -> 커맨드객체방식으로 처리 (service에서 객체를 요구하기때문에) 
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
						//커맨드 객체 : 객체 + 어노테이션 X
		EmpVO findVO = empService.empInfo(empVO);
		
		model.addAttribute("emp", findVO);
		return "emp/info";
	}
	
	//등록(페이지) : GET, 빈페이지라 가정
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert"; 
	}
	
	//등록(처리) : POST => HTML의 <form/>태그 + submit
				   //=> QueryString + 객체 => 커맨드객체방식으로 처리
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		
		int eid = empService.empInsert(empVO);
		String url = null;
		if( eid > -1) {
			//정상적으로 등록
			url = "redirect:empInfo?employeeId=" + eid;
		} else {
			//등록되지 않은 경우
			url = "redirect:empInsert";
		}
		return url;
	}
	
	//수정(페이지) : GET, 단건조회와 비슷함 경로와 메서드이름만 수정해줌
	@GetMapping("empUpdate")
	public String empUpdate(EmpVO empVO, Model model) {
						//커맨드 객체 : 객체 + 어노테이션 X
		EmpVO findVO = empService.empInfo(empVO);
		
		model.addAttribute("emp", findVO);
		return "emp/update";
	}
	
	//수정(처리) : POST, AJAX로 보내는 데이터형식 2가지를 알아본다.
	// 1)AJAX => QueryString
	//@PostMapping("empUpdate")
	@ResponseBody //AJAX처리를 위한 필수적인 어노테이션, AJAX -> Model 객체 사용하지않음
	public Map<String, Object> empUpdateAJAXQueryString(EmpVO empVO){
		return empService.empUpdate(empVO); //서비스로부터 받은 ModelAndView를 그대로 반환
	}
	// 2)AJAX => JSON (JSON은 @RequestBody 어노테이션을 요구한다.)
	// 정상 실행을 위한 1개 주석처리
	@PostMapping("empUpdate")
	@ResponseBody //AJAX처리를 위한 필수적인 어노테이션, AJAX -> Model 객체 사용하지않음
	public Map<String, Object> empUpdateAJAXJSON(@RequestBody EmpVO empVO){ //보내는 데이터가 달라지는 것이 아닌, 표현방식만 달라짐
		return empService.empUpdate(empVO); //서비스로부터 받은 ModelAndView를 그대로 반환
	}
	
	
	//삭제 : GET => QueryString + 단일값 -> @RequestParam (필수는아니나 사용자의입력값이 기능상 큰 영향을 줄 경우 @RequestParam을 사용해 제약을걸어야한다.)
	@GetMapping("empDelete")
	public String empDelete(Integer empId) {
		empService.empDelete(empId);
		return "redirect:empList";
	}
	
	
}
