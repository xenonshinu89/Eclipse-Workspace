package com.anchil.springMVCHibernateDemo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.anchil.springMVCHibernateDemo.Model.Employee;

public class EmployeeDao {

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	//method to save employee 
	@Transactional(readOnly = false)
	public void saveEmployee(Employee e){  
	    template.save(e);  
	}  
	//method to update employee  
	@Transactional(readOnly = false)
	public void updateEmployee(Employee e){  
	    template.update(e);  
	}  
	//method to delete employee 
	@Transactional(readOnly = false)
	public void deleteEmployee(Employee e){  
	    template.delete(e);  
	}  
	//method to return one employee of given id  
	@Transactional(readOnly = true)
	public Employee getById(int id){  
	    Employee e=(Employee)template.get(Employee.class,id);  
	    return e;  
	}  
	//method to return all employees 
	@Transactional(readOnly = true)
	public List<Employee> getEmployees(){  
	    List<Employee> list=new ArrayList<Employee>();  
	    list=template.loadAll(Employee.class);  
	    return list;  
	}  
	
}
