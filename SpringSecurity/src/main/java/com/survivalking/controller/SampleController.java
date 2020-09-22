package com.survivalking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/*")
public class SampleController {
	
	@GetMapping("/all")
	public void doAll() {
		log.info("아무나 접근 가능");
	}
	
	@GetMapping("/member")
	public void doMemeber() {
		log.info("멤버만 접근가능");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("관리자 접근가능");
	}
}
