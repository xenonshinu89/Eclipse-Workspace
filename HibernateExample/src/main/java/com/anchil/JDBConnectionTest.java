package com.anchil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;


public class JDBConnectionTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		try {
			System.out.println("DB Connection Start");
			/*
			 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection
			 * con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root",
			 * "shinu"); Statement st=con.createStatement(); ResultSet
			 * rs=st.executeQuery("select * from Employee"); while(rs.next()) {
			 * System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)); }
			 */
			
			ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

		      
		    EmployeeDao dao=(EmployeeDao)ctx.getBean("EmployeeDaoBean");  
		      
		    Employee e=new Employee();  
		    e.setId(114);  
		    e.setEmployeeName("varun");  
		    e.setSalary(50000.00f);  
		      
		    dao.saveEmployee(e);  
			System.out.println("DB Connection End");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
