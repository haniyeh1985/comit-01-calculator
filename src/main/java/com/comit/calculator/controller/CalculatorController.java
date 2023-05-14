package com.comit.calculator.controller;



import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comit.calculator.bean.CalculatorBean;

import com.comit.calculator.service.CalculatorService;

import com.comit.calculator.util.Util;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;


//import com.comit.realestate.bean.RealestateBean;
//import com.comit.realestate.service.RealestateService;
//import com.comit.realestate.util.Util;


@Controller
public class CalculatorController {
	
	 private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 CalculatorService calculatorService;
	 
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
@GetMapping("/list")
public ModelAndView list() {
		logger.debug("Listing Properties");
		List<CalculatorBean> properties =this.calculatorService.listProperties();
		return new ModelAndView("list","properties",properties);
	}	
@GetMapping("/create")
public String showCreate() {
	logger.debug("Show Create");
	
	return "create";
}

@PostMapping("/create")
public String createProperty(HttpServletRequest req) {
	logger.debug("Create Property");
	
	String type = req.getParameter("type");
	String squareFeet= req.getParameter("squareFeet");
	String yearPropery = req.getParameter("yearPropery");
	String bedroomNumbers = req.getParameter("bedroomNumbers");
	String bathroomNumbers = req.getParameter("bathroomNumbers");
	String balcony = req.getParameter("balcony");
	String pool = req.getParameter("pool");
	String backyard = req.getParameter("backyard");
	String garage = req.getParameter("garage");
	
	CalculatorBean property=this.createPropertyBean(null,type,squareFeet,yearPropery,bedroomNumbers,bathroomNumbers,balcony,pool,backyard,garage);
	this.calculatorService.createProperty(property);
	return "redirect:/list";	
   }


@GetMapping("/update/{id}")
public ModelAndView showUpdate(@PathVariable int id) {
	logger.debug("Show Update");
	CalculatorBean property=this.calculatorService.findProperty(id);
	return new ModelAndView("update","property",property);
}

@PostMapping("/update")
public String updateProperty(HttpServletRequest req) {
	logger.debug("Update Property");
	
	String id = req.getParameter("id");
	String type = req.getParameter("type");
	String squareFeet= req.getParameter("squareFeet");
	String yearPropery = req.getParameter("yearPropery");
	String bedroomNumbers = req.getParameter("bedroomNumbers");
	String bathroomNumbers = req.getParameter("bathroomNumbers");
	String balcony = req.getParameter("balcony");
	String pool = req.getParameter("pool");
	String backyard = req.getParameter("backyard");
	String garage = req.getParameter("garage");
	
	CalculatorBean property = this.createPropertyBean(id, type, squareFeet, yearPropery, bedroomNumbers, bathroomNumbers, balcony, pool, backyard, garage);
	
	this.calculatorService.updateProperty(property);
	
	return "redirect:/list";
}

@GetMapping("/delete/{id}")
public String deleteProperty(@PathVariable int id) {
	this.calculatorService.deleteProperty(id);
	return "redirect:/list";
}
   private CalculatorBean createPropertyBean(String id, String type,String squareFeet,String yearPropery,String bedroomNumbers,String bathroomNumbers,String balcony,String pool,String backyard,String garage) {
	CalculatorBean property= new CalculatorBean(Util.parseId(id),type, Double.valueOf(squareFeet),Util.parseDate(yearPropery),Integer.valueOf(bedroomNumbers),Integer.valueOf(bathroomNumbers),balcony,pool,backyard,garage,' ');
		
		return property;
	}








 
}

