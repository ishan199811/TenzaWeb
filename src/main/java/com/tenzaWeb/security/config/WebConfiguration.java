package com.tenzaWeb.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfiguration extends WebSecurityConfigurerAdapter {
	@Qualifier("userDetailsServiceImpl")

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
	  return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/assets/**", "/resources/**", "/registration", "/regg", 
						"/js/**", "/unitt","/**","/user/**","/css/**")
				.permitAll()
			//.antMatchers("/user/**").hasAnyAuthority("USER")
			//.antMatchers("/admin").hasAnyAuthority("ADMIN")
				.anyRequest().authenticated().and().formLogin().loginPage("/loginpage").loginProcessingUrl("/loginn")
				.permitAll().and().logout().permitAll();

	}

	/*
	 * @Bean public DaoAuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(userDetailsService());
	 * authProvider.setPasswordEncoder(bCryptPasswordEncoder());
	 * 
	 * return authProvider; }
	 */
	 @Override 
	 protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception { auth.userDetailsService(userDetailsService).passwordEncoder(
	  bCryptPasswordEncoder());

	  }
	 
	 @Bean
	    public AuthenticationManager customAuthenticationManager() throws Exception {
	        return authenticationManager();
	    }
}


