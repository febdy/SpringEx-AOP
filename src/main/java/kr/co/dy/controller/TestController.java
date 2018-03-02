package kr.co.dy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dy.service.TestService;
import kr.co.dy.service2.TestService2;

@Controller
public class TestController {

	@Autowired
	TestService testService;
	
	@Autowired
	TestService2 testService2;

	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	public String doA(Model model) {
		String serviceResult = testService.testService1();
		model.addAttribute("msg", serviceResult);

		return "doA";
	}
	
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public String doB() {
		testService.doBService();
		testService2.doCqwer();
		
		return "doA";
	}
	
}
