package com.example.webapp.firstWebApp.okta.sso;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RestController;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
	    .authorizeRequests(authorizeRequests ->
	        authorizeRequests
	            .antMatchers("/login").permitAll()
	            .anyRequest().authenticated()    
	    )	    
	    .oauth2Login(login ->
	        login
	            .defaultSuccessUrl("/welcome", true)
	    )
	    .logout(logout -> logout
	        .logoutSuccessUrl("/")
	        .invalidateHttpSession(true)
	        .clearAuthentication(true)
	        .deleteCookies("JSESSIONID")
	        .deleteCookies("CSRF-TOKEN")
	    )
	    .csrf().disable()
	    //.csrf(csrf -> csrf
	    //    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));	
	    .headers().frameOptions().disable();
	}
	
	   @Bean
	    public GrantedAuthoritiesMapper userAuthoritiesMapper() {
	        return (authorities) -> authorities;
	    }

}
