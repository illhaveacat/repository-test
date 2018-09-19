package com.tota.datadict;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.tota.datadict.mapper")
@ServletComponentScan("com.tota.datadict.filter")
public class DatadictApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatadictApplication.class, args);
	}
}
