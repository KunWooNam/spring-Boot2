package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper") //위에꺼 읽는김에 이것도 같이 읽어준다.
public class Boot01Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Boot01Application.class, args);
	}
	
}	
