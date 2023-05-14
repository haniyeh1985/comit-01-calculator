package com.comit.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comit.calculator.bean.CalculatorBean;

import com.comit.calculator.dao.CalculatorDao;


@Service
public class CalculatorService {

	
	@Autowired
	CalculatorDao calculatorDao;
	
	public List<CalculatorBean> listProperties() {
        

		List<CalculatorBean> properties = this.calculatorDao.listProperties();
		
		return properties;
	}
	
	public void createProperty(CalculatorBean property) {
		this.validateProperty(property);
		this.calculatorDao.createProperty(property);
	}
	

	public CalculatorBean findProperty(int idProperty) {
		return this.calculatorDao.findProperty(idProperty);
	}
	
	public void updateProperty(CalculatorBean property) {
		this.validateProperty(property);
		this.calculatorDao.updateProperty(property);
	}
	
	public void deleteProperty(int idProperty) {
		this.calculatorDao.deleteProperty(idProperty);
	}
	private void validateProperty(CalculatorBean property) {

		if (property.getType().isEmpty() ) {
			throw new RuntimeException("Invalid User Data: " + property);
		}
	
	
	}
	
	
	
	
	

}
