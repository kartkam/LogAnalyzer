package com.logAnalyzer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logAnalyzer")
public class PagesController {

	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String mainPage() {
		return "logAnalyzer";
	}
	
}
