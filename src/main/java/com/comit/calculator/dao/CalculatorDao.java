package com.comit.calculator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.comit.calculator.bean.CalculatorBean;

import com.comit.calculator.util.Util;

@Repository
public class CalculatorDao {

		List<CalculatorBean> properties;
		public  CalculatorDao() {
			this.properties= new ArrayList<CalculatorBean>();
			
			properties.add(new CalculatorBean(1, "house",80,Util.parseDate("1986-02-01"),1,1,"No","yes","yes", "yes",'A'));
			properties.add(new CalculatorBean(2, "apartment",100,Util.parseDate("1986-02-01"),4,3,"No","yes","yes", "yes",'A'));
			properties.add(new CalculatorBean(3, "house",120,Util.parseDate("1986-02-01"),3,2,"No","yes","yes", "yes",'A'));
			properties.add(new CalculatorBean(4, "house",200,Util.parseDate("1986-02-01"),6,4,"No","yes","yes", "yes",'A'));
			
		}

	public List<CalculatorBean> listProperties() {
		
		return this.properties;
	}
	
	public synchronized void createProperty(CalculatorBean property) {
		  
		  int max= this.properties.stream().mapToInt(p->p.getIdProperty()).max().orElse(0);
		 
		  property.setIdProperty(++max);
		  property.setStatuse('A');
		  this.properties.add(property);
	  }
	
	public CalculatorBean findProperty(int idProperty) {
		  return this.properties.stream()
				                .filter(p->p.getIdProperty()==idProperty)
				                .findAny().orElse(null);
	  }
	  
	  public void  updateProperty(CalculatorBean property) {
		  
		  CalculatorBean currentProperty=this.findProperty(property.getIdProperty());
		  if(currentProperty !=null) {
			  currentProperty.setType(property.getType());
			  currentProperty.setSquareFeet(property.getSquareFeet());
			  currentProperty.setYearPropery(property.getYearPropery());
			  currentProperty.setBedroomNumbers(property.getBedroomNumbers());
			  currentProperty.setBathroomNumbers(property.getBathroomNumbers());
			  currentProperty.setBalcony(property.getBalcony());
			  currentProperty.setPool(property.getPool());
			  currentProperty.setBackyard(property.getBackyard());
			  currentProperty.setGarage(property.getGarage());
		  }
		  
	  }
	  public void deleteProperty(int idProperty) {
		  this.properties.removeIf(p->p.getIdProperty()==idProperty);
	  }
	

}
