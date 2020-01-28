package com.example.angapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
class AngularController {
	
	@RequestMapping(value = "/**/{[path:[^\\.]*}")
	public String redirectUi() {
		return "forward:index.html";
	}
}