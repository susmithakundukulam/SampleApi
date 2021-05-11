package com.sample.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource secDataSource;
	

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	
//	@Override 
//	protected void configure(AuthenticationManagerBuilder auth) throws
//	  	Exception { 
//		 //code for login credentials to get from database		
//		System.out.println("************************secDataSource");
//		 auth.jdbcAuthentication()
//		 .passwordEncoder(new BCryptPasswordEncoder())
//		 .dataSource(secDataSource);
//		  
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
			/*// dont authenticate this particular request
	    	.authorizeRequests().antMatchers("/authenticate").permitAll()
	    	// all other requests need to be authenticated
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().permitAll()
	        .and()
	        .logout().permitAll()
	        .and()
	        // make sure we use stateless session; session won't be used to
			// store user's state.
	        .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
	    
	 // We don't need CSRF for this example
	 		.csrf().disable()
	 				// dont authenticate this particular request
	 				.authorizeRequests().antMatchers("/sec/authenticate").permitAll().
	 				// all other requests need to be authenticated
	 				anyRequest().authenticated().and().
	 				// make sure we use stateless session; session won't be used to
	 				// store user's state.
	 				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
	 				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	    
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}
}
