package com.secure.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springdocs")
public class SpringController {

	@GetMapping
	public void redirectToSpringDocs(HttpServletResponse response) throws IOException {
		response.sendRedirect(
				"https://docs.spring.io/spring-security/site/docs/current/guides/html5/helloworld-boot.html");
	}
}
