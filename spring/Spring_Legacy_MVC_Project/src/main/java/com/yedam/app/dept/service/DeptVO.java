package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
}
