package com.anchil.springMVCHibernateDemo.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anchil.springMVCHibernateDemo.Dao.UserDao;
import com.anchil.springMVCHibernateDemo.Model.User;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{

	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> users=userDao.findByUserName(username);
		users.orElseThrow(()-> new UsernameNotFoundException("Not Found"+username));
		
		return users.map(UserDetailsImpl::new).get();
	}
	
	

}
