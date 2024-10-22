package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.emp.EmpVO;
import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{
	private EmpMapper empMapper;
	
	//@Autowired => 생성자가 하나만 사용될 경우 생략이 가능하다.
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}
	
	@Override
	public List<EmpVO> empList() {
		return empMapper.selectAllList();
	}

	@Override
	public EmpVO empInfo(EmpVO empVO) {
		return empMapper.selectInfo(empVO);
	}

	@Override
	public int empInsert(EmpVO empVO) {
		return empMapper.insertInfo(empVO);
	}

	@Override
	public Map<String, Object> empUpdate(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		boolean flag = false;
		int result = empMapper.updateInfo(empVO.getEmployeeId(), empVO);
		
		if(result == 1) {
			flag = true;
		}
		map.put("result", flag);
		map.put("target", empVO);
		/* 주로 AJAX를 위한 JSON으로 이용하기 위해 map을 사용한다.
		 {
		 	"result" : true,
		 	"target" : {
		 					employeeId : 100,
		 					lastName : "King",
		 					...
		 				}
		 */
		return map;
	}

	@Override
	public Map<String, Object> empDelete(int empId) {
		Map<String, Object> map = new HashMap<>();
		int result = empMapper.deleteInfo(empId);
		
		if(result == 1) {
			map.put("employeeId", empId);
		}
		// {}
		// {"employeeId" : 104}
		return map;
	}

}
