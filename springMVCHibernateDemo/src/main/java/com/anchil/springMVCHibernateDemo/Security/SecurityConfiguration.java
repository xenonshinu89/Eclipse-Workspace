package com.anchil.springMVCHibernateDemo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.anchil.springMVCHibernateDemo.Dao.UserDao;

@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses=com.anchil.springMVCHibernateDemo.Dao.UserDao.class)
@ComponentScan(basePackages = "com.anchil.springMVCHibernateDemo")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

	
	  @Autowired 
	  UserDetailsService userDetailsService;
	  
	  @Override 
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  // TODO Auto-generated method stub
		  auth.userDetailsService(userDetailsService); 
	  }
	  
	  @Override 
	  protected void configure(HttpSecurity http) throws Exception { 
		  //	  TODO Auto-generated method stub 
		  http.authorizeRequests()
		  .antMatchers("/admin","/*Employee*").hasRole("ADMIN")
		  .antMatchers("/user","/*Employee*").hasAnyRole("ADMIN","USER")
		  //.antMatchers("/addTaskItem").hasAnyRole("ADMIN","USER")
		  .antMatchers("/").permitAll() .and().formLogin(); 
		  http.csrf().disable();
		  http.headers().frameOptions().disable(); 
	  }
	  
	  @Bean 
	  public PasswordEncoder getPasswordEncoder() {
		  return NoOpPasswordEncoder.getInstance(); 
	  }
	 

	
	
}
