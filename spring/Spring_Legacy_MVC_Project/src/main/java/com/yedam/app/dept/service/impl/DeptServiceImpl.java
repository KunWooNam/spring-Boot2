package com.yedam.app.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Service // Bean 등록, 비지니스 로직 담당 => AOP가 적용됨, @Component 는 곤란. Spring이 지원하는 것을 연결할 필요가 있음.
public class DeptServiceImpl implements DeptService{
	
	private DeptMapper deptMapper;
	
	@Autowired // 생성자 주입
	public DeptServiceImpl(DeptMapper deptMapper) {
		this.deptMapper = deptMapper;
	}
	
	@Override
	public List<DeptVO> getDeptList() {
		return deptMapper.selectAll();
	}
}
