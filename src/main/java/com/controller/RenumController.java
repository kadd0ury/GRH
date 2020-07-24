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
import com.entity.Renum;
import com.service.RenumSer;





@Controller
@RequestMapping("/renum")
public class RenumController {
	
	
	@Autowired
	private RenumSer renumser ;
	
	
	
	
	@GetMapping("/liste")
	public String getAllRenum(Model model) {
		List <Renum> listerenum =renumser.getRenum();
		model.addAttribute("listerenum",listerenum);
		return "list-renum";	
	}
	
	
	@GetMapping ("/show")
	public String showForm (Model model) {
		Renum renum  = new Renum();
		model.addAttribute("renum",renum);
		return "renum-form";
	
	}
	
	@PostMapping("/save")
	public String saveSup(@Valid @ModelAttribute("renum") Renum renum,BindingResult result,ModelMap model){
		
		if (result.hasErrors()) {
			model.addAttribute("renum",renum);
			return "renum-form";
		}
		renumser.saveRenum(renum);

		return "redirect:/renum/liste";
		
	}
	
	 @GetMapping("/update")
	    public String showFormForUpdate(@RequestParam("renumId") int theId ,Model theModel){
	        Renum theRenum = renumser.getRenum(theId);
	        theModel.addAttribute("renum", theRenum);
	        return "renum-form";
	    }
	 
	 @GetMapping("/delete")
	    public String deleteRenum(@RequestParam("renumId") int theId) {
		 renumser.deleteRenum(theId);
	        return "redirect:/renum/liste";
	    }
	 
	
	
	
	
	
	
	
	
	
	
	

}
