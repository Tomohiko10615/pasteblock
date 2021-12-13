package com.pasteblock.pasteblock.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pasteblock.pasteblock.app.models.services.JpaUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/api/**").permitAll()
		.antMatchers("/blockers/**").hasAnyAuthority("Admin")
		.antMatchers("/clientes/**").hasAnyAuthority("Admin")
		.antMatchers("/contratos/**").hasAnyAuthority("Admin")
		.antMatchers("/mensajes/**").hasAnyAuthority("Admin")
		.antMatchers("/").hasAnyAuthority("Admin")
		.antMatchers("/home").hasAnyAuthority("Admin")
		.and()
		    .formLogin()
		    .loginPage("/login")
		    .usernameParameter("email")
		    .permitAll()
		.and()
		.logout().permitAll();

	}


	@Autowired
	public void configurerGlobal (AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService)
		.passwordEncoder(encoder);
	}
}
