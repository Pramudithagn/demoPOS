package com.personal.pos.demoPOS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoPosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPosApplication.class, args);
	}

}
