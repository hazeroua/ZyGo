package com.zygo.mvc.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.zygo.mvc.Service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private DataSource dataSource;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("123")).roles("USER");
////		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("123")).roles("ADMIN");
////		auth.inMemoryAuthentication().withUser("scol").password(passwordEncoder().encode("123")).roles("SCOLARITE");
////
////		
//		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//		.dataSource(dataSource)//https://bcrypt-generator.com/ pour crypto le mdp
//		.usersByUsernameQuery("select username ,password, true from users where username = ?")
//		.authoritiesByUsernameQuery("select user_username, roles_role from users_roles where user_username=?")
//		.rolePrefix("ROLE_");
//		}
//	
	
	 @Bean 
	    public MyUserDetailsService userDetailsService() {
	        return new MyUserDetailsService();
	    }
	 @Bean
	 public HttpSessionEventPublisher httpSessionEventPublisher() {
	     return new HttpSessionEventPublisher();
	 }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**","/img/**", "/images/**").permitAll();
	   http
	      .authorizeRequests().antMatchers("/register").anonymous()//pour ne pas etre obliger de me connecter pour register
	      .anyRequest().authenticated()
	      .and()
	      .formLogin()
	      .loginPage("/login")
		     .permitAll()
		     .defaultSuccessUrl("/index")
		     .failureUrl("/error");
	   http.sessionManagement().maximumSessions(1);
	   

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
