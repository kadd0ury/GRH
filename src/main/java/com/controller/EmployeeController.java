package com.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.converter.StoreFormatter;
import com.entity.Dept;
import com.entity.Employee;
import com.entity.Renum;
import com.service.DeptSer;
import com.service.EmployeeSer;
import com.service.RenumSer;



@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeSer employeeser ;
	

	@Autowired
	private RenumSer renumser ;
	
	@Autowired
	private DeptSer deptSer ;
	
	
	
	
	
	
	Set <String>listeMangers = new HashSet();
	Set <String>listeSup = new HashSet();
	
	List<String>listeDept = new ArrayList<String>();
	
	//public List<String> getDepts(){
		//for (Dept dept : deptSer.getAllDepts() ) {
			//listeDept.add(dept.getNom());
		//}
		//return  listeDept ;
	//}
	
	
	
	
	
	Set <String> getManagers(){
		for (Employee mpl : employeeser.getEmployeeByGrade("Manager")) {
			listeMangers.add(mpl.getLastName());
		}
		listeMangers.add("-");
		return listeMangers ;
	}
	
	Set<String>getSup(){
		
		for (Employee mpl : employeeser.getEmployeeByGrade("Sup")) {
			listeSup.add(mpl.getLastName());	
		}
		
		listeSup.add("-");
		return listeSup;
		
		
	}
	
	
	
	
	
	@Autowired(required = true)
	public void setEmployee( EmployeeSer cusmSer) {
		this.employeeser = cusmSer ;}
	
	

	
	@GetMapping("/index")
	public String index () {
		return "index";
		
		
	}
	
	@GetMapping("/listE")
	public  String ShowFormAdd (Model model) {
		List <Employee> theEmployees = employeeser.getEmployees();
		model.addAttribute("employees", theEmployees);
		
		return "list-employee";
	}
	
	@GetMapping ("/showFormC")
	public String ShowForm(Model model) {
		
		List<Dept>mydepts = deptSer.getAllDepts();
		
		List<Renum>myRenum = renumser.getRenum();

		Employee theEmployees = new Employee();	
		List <String>grades = new ArrayList <String>();
		grades.add("Employee");grades.add("Manager");grades.add("Sup");
		model.addAttribute("managers",getManagers());
        model.addAttribute("superieur",getSup());
		model.addAttribute("grades",grades);
		model.addAttribute("employee",theEmployees);
		model.addAttribute("mydepts",mydepts);
		model.addAttribute("myrenums",myRenum);
		
		
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee theEmployee,BindingResult result,ModelMap model){
		if (result.hasErrors()) {
			List<Renum>myRenum = renumser.getRenum();
			List<Dept>mylist = deptSer.getAllDepts();
			List <String>grades = new ArrayList <String>();
			grades.add("Employee");grades.add("Manager");grades.add("Sup");
			model.addAttribute("grades",grades);
			model.addAttribute("superieur",getSup());
			model.addAttribute("managers",getManagers());
			model.addAttribute("employee",theEmployee);
			model.addAttribute("mydepts",mylist);
			model.addAttribute("myrenums",myRenum);
			return "employee-form";
		}
		
		
		   for (Dept obj : deptSer.getAllDepts()) {
	        	if (obj.getId()==theEmployee.getMyDept()) {
	        		theEmployee.setDept(obj);
	        	}
	        	
	        }
		   
		   for (Renum obj : renumser.getRenum()) {
	        	if (obj.getId()==theEmployee.getMyRenum()) {
	        		theEmployee.setReum(obj);
	        	}
	        	
	        }
		
	
		
		
		employeeser.saveEmployee(theEmployee);
		return "redirect:/employee/listE";
	}
	
	 @GetMapping("/update")
	    public String showFormForUpdate(@RequestParam("employeeId") int theId ,Model theModel){
	        Employee theemployee = employeeser.getEmployee(theId);
	        List<Dept>mydepts = deptSer.getAllDepts();
			List<Renum>myRenum = renumser.getRenum();
	        List <String>grades = new ArrayList <String>();
			grades.add("Employee");grades.add("Manager");grades.add("Sup");
			theModel.addAttribute("superieur",getSup());
			theModel.addAttribute("managers",getManagers());
			theModel.addAttribute("grades",grades);
	        theModel.addAttribute("employee", theemployee);
	        theModel.addAttribute("mydepts",mydepts);
	        theModel.addAttribute("myrenums",myRenum);
	        return "employee-form";
	    }
	 
	 @GetMapping("/delete")
	    public String deleteEmployee(@RequestParam("employeeId") int theId) {
		 
		 String grade_del = employeeser.getEmployee(theId).getLastName();
		 
		 List<Employee>liste = employeeser.getEmployees();	 
		 employeeser.deleteEmployee(theId);
		 
	        return "redirect:/employee/listE";
	    }
	 
	  @RequestMapping("/view/{id}")
	    public String view(@PathVariable("id") long id,ModelMap model) {
	        model.addAttribute("employee",employeeser.getEmployee(id));
	        return "details";
	    }
	
	
	
	
	

}
