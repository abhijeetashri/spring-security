package com.secure.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

	@GetMapping(produces = MediaType.TEXT_HTML_VALUE)
	public String greet() {
		return "Hello from application";
	}
}
