package com.comit.calculator.bean;


import java.util.Date;


public class CalculatorBean {

	int idProperty;
	String type;
	double squareFeet;
	Date yearPropery;
	int bedroomNumbers;
	int bathroomNumbers;
	String balcony;
	String pool;
	String backyard;
	String garage;
	char status;
	
	public CalculatorBean(int idProperty, String type, double squareFeet, Date yearPropery, int bedroomNumbers,
			int bathroomNumbers, String balcony, String pool, String backyard, String garage, char status) {
		super();
		this.idProperty = idProperty;
		this.type = type;
		this.squareFeet = squareFeet;
		this.yearPropery = yearPropery;
		this.bedroomNumbers = bedroomNumbers;
		this.bathroomNumbers = bathroomNumbers;
		this.balcony = balcony;
		this.pool = pool;
		this.backyard = backyard;
		this.garage = garage;
		this.status =status;
	}
	public int getIdProperty() {
		return idProperty;
	}
	public void setIdProperty(int idProperty) {
		this.idProperty = idProperty;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(double squareFeet) {
		this.squareFeet = squareFeet;
	}
	public Date getYearPropery() {
		return yearPropery;
	}
	public void setYearPropery(Date yearPropery) {
		this.yearPropery = yearPropery;
	}
	public int getBedroomNumbers() {
		return bedroomNumbers;
	}
	public void setBedroomNumbers(int bedroomNumbers) {
		this.bedroomNumbers = bedroomNumbers;
	}
	public int getBathroomNumbers() {
		return bathroomNumbers;
	}
	public void setBathroomNumbers(int bathrooNumbers) {
		this.bathroomNumbers = bathrooNumbers;
	}
	public String getBalcony() {
		return balcony;
	}
	public void setBalcony(String balcone) {
		this.balcony = balcone;
	}
	public String getPool() {
		return pool;
	}
	public void setPool(String pool) {
		this.pool = pool;
	}
	public String getBackyard() {
		return backyard;
	}
	public void setBackyard(String backyard) {
		this.backyard = backyard;
	}
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	public char getStatuse() {
		return status;
	}
	public void setStatuse(char status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RealestateBean [idProperty=" + idProperty + ", type=" + type + ", squareFeet=" + squareFeet
				+ ", yearPropery=" + yearPropery + ", bedroomNumbers=" + bedroomNumbers + ", bathroomNumbers="
				+ bathroomNumbers + ", balcony=" + balcony + ", pool=" + pool + ", backyard=" + backyard + ", garage="
				+ garage + ", status=" + status + "]";
	}

	
}
