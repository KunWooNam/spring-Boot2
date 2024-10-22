package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.EmpVO;

//		com.yedam.app.**.mapper => mapperScan에 등록된 것과 같으면 됨.
public interface EmpMapper {
	//Mapper의 메서드는 SQL문의 실행 형태를 그대로 반영
	//전체조회
	public List<EmpVO> selectAllList();
	//단건조회
	public EmpVO selectInfo(EmpVO empVO);
	//등록
	public int insertInfo(EmpVO empVO);
	//수정
	public int updateInfo(@Param("id") int eid, @Param("emp") EmpVO empVO);
	//삭제
	public int deleteInfo(int employeeId);
}