package com.fhsu.redtrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RedtradeApplication {

	public static void main(String[] args) {

		SpringApplication.run(RedtradeApplication.class, args);
	}

}
