package com.lginfor.common.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class WelcomeController {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) throws Exception {

		logger.error("error demos: welcome");
//		logger.debug("welcome() is executed, value {}", "Welcome");


//		logger.error("This is Error message", new Exception("Testing"));

		model.addAttribute("msg", "Hello Spring MVC + Log4J.");
		
		boolean needThrows = false;
		if (needThrows)
			throw new Exception("test response errors.");
		
		return "welcome";

	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession,Model model) throws Exception {

		logger.error("error demos: logout");
//		logger.debug("welcome() is executed, value {}", "Welcome");


//		logger.error("This is Error message", new Exception("Testing"));

		model.addAttribute("msg", "Logoff Spring MVC + Log4J.");
		
		httpSession.invalidate();
		logger.error("error demos: logout httpSession.invalidate()");
		return "welcome";

	}


}