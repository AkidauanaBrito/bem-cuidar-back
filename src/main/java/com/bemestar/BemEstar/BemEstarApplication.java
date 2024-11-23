package com.bemestar.BemEstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BemEstarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BemEstarApplication.class, args);
	}
 	@GetMapping("/")
	public String apiRoot(){
		return "hello world!";
	}
}
