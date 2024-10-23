package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.EmpVO;
import com.yedam.app.emp.mapper.EmpMapper;

@SpringBootTest
class Boot01ApplicationTests {
	@Autowired //실제기능구현시 사용권장 X
	private EmpMapper empMapper;
	@Test
	void contextLoads() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("hong@google.com");
		empVO.setJobId("IT_PROG");
		
		int result = empMapper.insertInfo(empVO);
		assertEquals(result, 1);
	}

}
