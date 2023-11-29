package com.codingdojo.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
@Controller

public class MainController{
	@RequestMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@RequestMapping("/omikuji")
	public String omikuji() {
		return "demo.jsp";
	}
	
	@PostMapping("/submit")
	public String submit(HttpSession session,
			@RequestParam(value="cityName") String cityName,
			@RequestParam(value="number") String number,
			@RequestParam(value="personName") String personName,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="comment") String comment) {
		
		session.setAttribute("cityName", cityName);
		session.setAttribute("number",number);
		session.setAttribute("personName",personName);
		session.setAttribute("hobby",hobby);
		session.setAttribute("thing",thing);
		session.setAttribute("comment",comment );
		
		return "redirect:/show";
	}
	
	@RequestMapping("/back")
	public String back(HttpSession session) {
		session.removeAttribute("cityName");
		session.removeAttribute("number");
		session.removeAttribute("personName");
		session.removeAttribute("hobby");
		session.removeAttribute("thing");
		session.removeAttribute("comment");
		
		return "redirect:/omikuji";
	}
	@RequestMapping("/show")
	public String show(HttpSession session,Model model) {
		
		String cityName = (String)  session.getAttribute("cityName");
		String number = (String)  session.getAttribute("number");
		String personName = (String)  session.getAttribute("personName");
		String hobby = (String)  session.getAttribute("hobby");
		String thing = (String)  session.getAttribute("thing");
		String comment = (String)  session.getAttribute("comment");
		
		model.addAttribute("cityName",cityName);
		model.addAttribute("number",number);
		model.addAttribute("personName",personName);
		model.addAttribute("hobby",hobby);
		model.addAttribute("thing",thing);
		model.addAttribute("comment",comment);
		
		return "show.jsp";
	}
}
