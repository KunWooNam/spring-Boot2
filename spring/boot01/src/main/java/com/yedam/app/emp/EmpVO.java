package com.yedam.app.emp;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// VO는 기능꺼다. DB것이 아님
// 게터만 있어야하는 경우 ,다른 생성자가 있어야 하는경우 등 @Data가 아닌 개별 어노테이션을 사용해야 한다.(안쓰는경우 은근히 많음)
//@Data 
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpVO {
	 private Integer employeeId;
	 private String firstName;
	 private String lastName;
	 private String email;
	 private String phoneNumber;
	 private Date hireDate;
	 private String jobId;
	 private Double salary;
	 private Double commissionPct;
	 private Integer managerId;
	 private Integer departmentId;
}    
