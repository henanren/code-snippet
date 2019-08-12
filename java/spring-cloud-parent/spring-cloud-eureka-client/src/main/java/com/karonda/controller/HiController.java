package com.karonda.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

	@Value("${server.port}")
	int port;

	@Value("${version}")
	String version;

	@GetMapping("/hi") // 需要token访问权限
	public String home(@RequestParam String name) {
		return "Hello " + name + ", from port: " + port + ", version: " + version;
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')") // 需要权限,需要 数据库的权限role
	@RequestMapping("/hello")
	public String hello() {
		return "hello!";
	}
}
