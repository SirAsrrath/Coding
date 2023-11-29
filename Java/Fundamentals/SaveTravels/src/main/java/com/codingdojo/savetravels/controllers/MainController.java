package com.codingdojo.savetravels.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

import jakarta.validation.Valid;


@Controller
public class MainController {
	
	@Autowired
	ExpenseService expenseServices;
	
	
	//Home page
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseServices.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	
	//New Expense Post
	@PostMapping("/create")
	public String index(@Valid @ModelAttribute("expense") Expense expense, BindingResult result , Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseServices.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}else {
			expenseServices.createExpense(expense);
			return "redirect:/";
		}
	}
	
	//Edit Expense
	@RequestMapping("/edit/{id}")
	public String editExpense(Model model, @PathVariable("id") Long id) {
		Expense expense1 = expenseServices.findExpense(id);
		model.addAttribute("expense",expense1);
		return "edit.jsp";
	}
	
	//Update database Post
	@PostMapping("/update/{id}")
	public String updateExpense(
			@PathVariable("id") Long id, 
			Model model, 
			@Valid @ModelAttribute("expense") Expense expense, 
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expenseServices.findExpense(id));
			return "redirect:/edit/{id}";
		}else {
			expenseServices.updateExpense(expense);
			return "redirect:/";
		}
	}
	
	//Delete by ID
	@RequestMapping("/delete/{id}")
	 public String deleteExpense(@PathVariable("id") Long id) {
		Expense expense = expenseServices.findExpense(id);
		expenseServices.deleteExpense(expense);
        return "redirect:/";
	}
	
	@RequestMapping("/view/{id}")
	public String viewExpense(Model model, @PathVariable("id") Long id) {
		Expense expense = expenseServices.findExpense(id);
		model.addAttribute("expense",expense);
		return "view.jsp";
	}
}
