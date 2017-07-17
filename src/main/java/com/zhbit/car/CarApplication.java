package com.zhbit.car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ServletComponentScan
@SpringBootApplication
@MapperScan("com.zhbit.car.service.user.mapper")
public class CarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}
}
