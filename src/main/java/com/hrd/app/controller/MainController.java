package com.hrd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrd.app.services.StudentService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
	public String homePage(ModelMap model){
		model.addAttribute("list", studentService.getAllStudents());
		return "home";
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String aboutPage(ModelMap model){
		model.addAttribute("message","hello about page");
		return "about";
	}
}
