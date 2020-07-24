package com.controller;

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
import com.entity.Dept;
import com.service.DeptSer;


@Controller
@RequestMapping("/dept")
public class DeptController{
	
	@Autowired
	private DeptSer deptSer ;
	
	
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	
	
	@GetMapping("/liste")
	public String getAllDepts(Model model) {
		List <Dept> listeDepts =deptSer.getAllDepts();
		model.addAttribute("depts",listeDepts);
		return "list-dept";	
	}
	
	@GetMapping ("/show")
	public String showForm (Model model) {
		Dept deptobj  = new Dept ();
		model.addAttribute("dept",deptobj);
		return "form-dept";
	
	}
	
	@PostMapping ("/save")
	public String saveDept(@Valid @ModelAttribute("dept") Dept theDept,BindingResult result,ModelMap model) {
		
		
		if (result.hasErrors()) {
			model.addAttribute("dept",theDept);
			return "form-dept";	
		}
		deptSer.saveDept(theDept);;
		return "redirect:/dept/liste";		
	}
	
	 @GetMapping("/update")
	    public String showFormForUpdate(@RequestParam("deptId") int theId ,Model theModel){
		 Dept deptobj = deptSer.getDept(theId);
	        theModel.addAttribute("dept", deptobj);
	        return "form-dept";
	    }
	 
	 @GetMapping("/delete")
	    public String deleteCustomer(@RequestParam("deptId") int theId) {
		 deptSer.deleteDept(theId);
	        return "redirect:/dept/liste";
	    }
	
	
	
	
	

}
