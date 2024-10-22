package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	// 전체 조회
	public List<DeptVO> selectAll();
	
}
