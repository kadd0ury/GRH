package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.User;
import com.service.UserSer;



@Controller
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	private UserSer userser ;
	
	
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	
	
	@GetMapping("/liste")
	public String getAllUsers(Model model) {
		List <User> listeUsers =userser.getAllUsers();
		model.addAttribute("users",listeUsers);
		return "list-user";	
	}
	
	@GetMapping ("/show")
	public String showForm (Model model) {
		
		List<String>roles = new ArrayList<String>();
		roles.add("Admin");roles.add("Viewer");
		User user  = new User ();
		model.addAttribute("user",user);
		model.addAttribute("roles",roles);
		return "form-user";
	
	}
	
	@PostMapping ("/save")
	public String saveDept(@Valid @ModelAttribute("user") User theUser,BindingResult result,ModelMap model) {
		
		
		if (result.hasErrors()) {
			List<String>roles = new ArrayList<String>();
			roles.add("Admin");roles.add("Viewer");
			model.addAttribute("roles",roles);
			model.addAttribute("user",theUser);
			return "form-user";	
		}
		userser.saveUser(theUser);;
		return "redirect:/user/liste";		
	}
	
	 @GetMapping("/update")
	    public String showFormForUpdate(@RequestParam("userId") int theId ,Model theModel){
		 User user = userser.getUser(theId);
			List<String>roles = new ArrayList<String>();
			roles.add("Admin");roles.add("Viewer");
			theModel.addAttribute("roles",roles);
	        theModel.addAttribute("user", user);
	        return "form-user";
	    }
	 
	 @GetMapping("/delete")
	    public String deleteUser(@RequestParam("userId") int theId) {
		 userser.deleteUser(theId);
	        return "redirect:/user/liste";
	    }
	
	
	
	
	

}
