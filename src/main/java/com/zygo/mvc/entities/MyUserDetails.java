package com.zygo.mvc.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	 private User user;
     
	    public MyUserDetails(User user) {
	        this.user = user;
	    }
	 
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return null;
	    }
	 
	   
	    public String getPassword() {
	        return user.getPassword();
	    }
	 
	    
	    public String getUsername() {
	        return user.getUsername();
	    }
	 
	    
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    
	    public boolean isEnabled() {
	        return true;
	    }
	     
	
}
