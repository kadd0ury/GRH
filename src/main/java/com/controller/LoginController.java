package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Login;
import com.entity.User;
import com.service.LoginService;
import com.service.UserSer;

@Controller
public class LoginController{
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserSer userservice ;
	
	@Autowired
	LoginService loginservice;
	
	
	
	@GetMapping ("/login")
	public String getForm(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
		
	}
	
	@PostMapping ("/login")
	public String login(@Valid @ModelAttribute("login") Login login, BindingResult result, Model model,HttpServletRequest request){
		
		String message = null;
		String var = null;
		User userEntry = loginservice.validateUser(login);
	
		if (userEntry != null) {
			
			

			//session.setAttribute("userAuth", userEntry);
			
			request.getSession(true).setAttribute("userAuth", userEntry);
			request.getSession(true).setAttribute("username", userEntry.getNom());
		
			System.out.print(((User) session.getAttribute("userAuth")).getNom() + "session");

			var = "redirect:/employee/index";
		}
		
		else {
			message = "les informations d'authentification sont incorectes";
			model.addAttribute("message", message);
			System.out.print(session.getAttribute("userAuth") + "session");
			var = "login";

		}
		
		
		
		return var;	
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession(true).setAttribute("userAuth", null);
		loginservice.setUserAuth();
		//session.setAttribute("userAuth", null);
		

		return "redirect:/login";

	}
	
	@GetMapping("/403")
	public String error() {

		return "unauthorized";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}