package com.codingdojo.loginandregistration.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.loginandregistration.models.Login;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.services.UserService;

@Controller
public class MainController {
 
  @Autowired
  private UserService userServ;
  
 // main page
 
 @GetMapping("/")
 public String index(Model model) {
 
     model.addAttribute("user", new User());
     model.addAttribute("login", new Login());
     return "index.jsp";
 }
 
 
 // register post, initiate session, validation redirect
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("user") User user, 
         BindingResult result, Model model, HttpSession session) {
     
     userServ.register(user, result);
     
     if(result.hasErrors()) {

         model.addAttribute("login", new Login());
         return "index.jsp";
     }
     
     session.setAttribute("userId", user.getId());
 
     return "redirect:/welcome";
 }
 
 
 // login post, initiate session, validation redirect
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("login") Login login, 
         BindingResult result, Model model, HttpSession session) {
     
  
     User user = userServ.login(login, result);
 
     if(result.hasErrors()) {
         model.addAttribute("user", new User());
         return "index.jsp";
     }
 
     session.setAttribute("userId", user.getId());
 
     return "redirect:/welcome";
 }
 
 
 // logout session clear
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.setAttribute("userId", null);
	 return "redirect:/";
 }
 
 @GetMapping("/welcome")
 public String welcome(Model model, HttpSession session) {
	 Long userId = (Long) session.getAttribute("userId");
	 if(userId==null) {
		 return "redirect:/";
	 }
	 User user = userServ.findById(userId);
	 model.addAttribute("user",user);
	 return "dashboard.jsp";
 }
 
}