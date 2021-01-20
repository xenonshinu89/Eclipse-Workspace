package com.anchil.springMVCHibernateDemo.Configuration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.anchil.springMVCHibernateDemo.Dao.EmployeeDao;
import com.anchil.springMVCHibernateDemo.Model.Employee;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { "com.anchil.springMVCHibernateDemo" })
@Controller
public class AppConfig {
	
	@Autowired
	EmployeeDao dao;

//	  @Bean
//	  public InternalResourceViewResolver resolver() 
//	  { 
//		  InternalResourceViewResolver resolver=new InternalResourceViewResolver();
//		  resolver.setViewClass(JstlView.class); resolver.setPrefix("/WEB-INF/view/");
//		  resolver.setSuffix(".jsp");
//	  
//		  return resolver;
//	  
//	  }
	
	@GetMapping("/")
	public ModelAndView home()
	{
		ModelAndView homeMV=new ModelAndView();
		homeMV.addObject("Title","Welcome  to App Home Page");
		homeMV.addObject("userName",getLoggedinUserName());
		homeMV.setViewName("Welcome");
		return homeMV;
	}
	
	@GetMapping("/user")
	public ModelAndView userLogin()
	{
		ModelAndView homeUser=new ModelAndView();
		homeUser.addObject("Title","Welcome User");
		homeUser.addObject("userName",getLoggedinUserName());
		homeUser.setViewName("addEmployee");
		return homeUser;
	}
	
	@GetMapping("/admin")
	public ModelAndView adminLogin()
	{
		ModelAndView homeAdmin=new ModelAndView();
		homeAdmin.addObject("Title","Welcome Admin");
		homeAdmin.addObject("user",getLoggedinUserName());
		homeAdmin.addObject("employee", dao.getEmployees());
		homeAdmin.setViewName("listEmployee");
		return homeAdmin;
	}
	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
	 

}
