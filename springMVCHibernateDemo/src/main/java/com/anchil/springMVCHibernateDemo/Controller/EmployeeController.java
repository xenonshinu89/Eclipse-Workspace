package com.anchil.springMVCHibernateDemo.Controller;

import java.net.Authenticator.RequestorType;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anchil.springMVCHibernateDemo.Dao.EmployeeDao;
import com.anchil.springMVCHibernateDemo.Model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("Employee") Employee e) {
		// TODO Auto-generated method stub
		
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("/WEB-INF/Spring-dispatcher-servlet.xml"); 
		//EmployeeDao dao=(EmployeeDao)ctx.getBean("EmployeeDaoBean"); 
		//System.out.println(e.getId()+" "+e.getEmployeeName()+ " "+ e.getSalary());
		//Employee e=new Employee(id,empName,sal);
		dao.saveEmployee(e);
		/*
		 * List<Employee> list=dao.getEmployees();
		 * 
		 * Iterator<Employee> it=list.iterator(); while(it.hasNext()) { Employee
		 * emp=(Employee)it.next();
		 * System.out.println(emp.getId()+" "+emp.getEmployeeName()+" "+emp.getSalary())
		 * ; }
		 */
		
		//System.out.println(list.get(0).getEmployeeName());
		ModelAndView mv=new ModelAndView();
		mv.addObject("employee",dao.getEmployees());
		mv.addObject("Title","List Employee");
		mv.setViewName("listEmployee");
		
		System.out.println("in link");
		return mv;
	}
	
	@GetMapping(value="/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam("id") int id) {
		dao.deleteEmployee((Employee)dao.getById(id));
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("employee",dao.getEmployees());
		mv.addObject("Title","List Employee");
		mv.setViewName("listEmployee");
		
		System.out.println("in link");
		return mv;
	}

}
