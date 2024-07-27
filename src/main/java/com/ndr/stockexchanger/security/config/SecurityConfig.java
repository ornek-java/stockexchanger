package com.ndr.stockexchanger.security.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Must create a bean that is used to configure a user store for authentication purposes. 
	 * This bean should implement UserDetailsService interface
	 * Spring Security offers several out-of-the-box implementations of UserDetailsService:
	 * - An in-memory user store
	 * - A JDBC user store
	 * - An LDAP user store
	 * 
	 */
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		List<UserDetails> usersList = new ArrayList<>();
		usersList.add(new User("stockexchanger", encoder.encode("pass1234"), 
									Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
		usersList.add(new User("admin", encoder.encode("password1"), 
				Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
		return new InMemoryUserDetailsManager(usersList);
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
		        .authorizeHttpRequests(auth -> auth
		                .requestMatchers("/userResource").hasRole("USER")
		                .requestMatchers("/adminResource").hasRole("ADMIN")
		                .requestMatchers("/publicResource").permitAll()
		            )
		        .httpBasic(Customizer.withDefaults())
		        .build();
	}
}
