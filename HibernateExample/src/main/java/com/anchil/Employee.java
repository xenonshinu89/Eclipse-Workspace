package com.anchil;




public class Employee {


	private int id;
	private String employeeName;
	private float salary;
	
	public Employee() {
		
	}
	
	
	
	
	public Employee(String employeeName, float salary) {
		super();
		this.employeeName = employeeName;
		this.salary = salary;
	}




	public Employee(int id, String employeeName, float salary) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	
}
