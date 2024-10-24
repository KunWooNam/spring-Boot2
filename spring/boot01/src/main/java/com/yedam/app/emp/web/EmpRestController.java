package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.EmpVO;
import com.yedam.app.emp.service.EmpService;

/*
 * AJAX + JSON + 다양한 클라이언트의 등장 => REST (새로운 형태의 서버)
 * => REST(새로운 형태의 서버)
 *  1) 페이지 없이 순수 데이터만 제공
 *  2) Endpoint(URI+Method)를 구성하는 새로운 방식
 *     URI(자원만 표기) + Method(GET, POST, PUT, DELETE / 기능을 의미)
 *  
 *  검색, 조회에 있어 쿼리스트링은 필수적이나 PathVariable로 최소화한다.
 * */
@Controller
@RestController //REST 방식은 메서드에 @ResponseBody을 매번 선언해줘야하는데, @RestController를 클래스에 선언해주면 각각에 @ResponseBody를 선언하지 않아도 된다. 자동으로 붙음.
public class EmpRestController {
	private EmpService empService;
	public EmpRestController(EmpService empService) {
		this.empService = empService;
	}
	
	//전체조회 : GET
	@GetMapping("emps")
	//@ResponseBody //AJAX => Model객체를 사용하지 않는다
	public List<EmpVO> empList(){
		return empService.empList(); /* RESTful은 기존방식에 비해 Model객체를 사용하지 않고 비지니스로직 결과값을 그대로 반환시킴 */
	}
	//단건조회 : GET
	@GetMapping("emps/{employeeId}") //전체조회와 경로를 구분하기 위해 검색조건에 대한 값 pathvariable을 사용
	public EmpVO empInfo(@PathVariable Integer employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		return empService.empInfo(empVO);
	}
	//등록 : POST
	@PostMapping("emps")
	public int empInsert(@RequestBody EmpVO empVO) { //@RequestBody => JSON
		return empService.empInsert(empVO);
	}
	//수정 : PUT ( <=> POST) => 전체 데이터가 움직인다.
	@PutMapping("emps/{employeeId}")
	public Map<String, Object> empUpdate(@PathVariable Integer employeeId, @RequestBody EmpVO empVO){
		empVO.setEmployeeId(employeeId);
		return empService.empUpdate(empVO);
	}
	
	//삭제 : DELETE ( <=> GET)
	@DeleteMapping("emps/{employeeId}") //REST방식의 Controller는 기본적으로 PathVariable, JSON 2가지를 이용해 데이터를 받는다.
	public Map<String, Object> empDelete(@PathVariable Integer employeeId){
		return empService.empDelete(employeeId);
	}
}