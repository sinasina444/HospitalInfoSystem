package com.stan.HospitalInfoDemo.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.stan.HospitalInfoDemo.security.handler.AccessDeniedHandlerImpl;
import com.stan.HospitalInfoDemo.security.handler.AuthenticationEntryPointImpl;
import com.stan.HospitalInfoDemo.security.handler.AuthenticationFailureHandlerImpl;
import com.stan.HospitalInfoDemo.security.handler.DoctorAuthenticationSuccessHandlerImpl;
import com.stan.HospitalInfoDemo.security.handler.LogoutSuccessHandlerImpl;
import com.stan.HospitalInfoDemo.security.handler.PatientAuthenticationSuccessHandlerImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder(11);
		return encoder;
	}
	
	/*
	 * cors support
	 */
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		//configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        //configuration.addAllowedOrigin("http://localhost:4201"); // You should only set trusted site here. e.g. http://localhost:4200 means only this site can access.
        configuration.addAllowedOrigin("*");
		configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
	@Configuration
	@Order(1)
	public static class DoctorConfigurationAdapter extends WebSecurityConfigurerAdapter {
		@Autowired
		AuthenticationEntryPointImpl authenticationEntryPointImpl;
		
		@Autowired
		AccessDeniedHandlerImpl accessDeniedHandlerImpl;
		
		@Autowired
		DoctorAuthenticationSuccessHandlerImpl doctorAuthenticationSuccessHandlerImpl;
		
		@Autowired
		PatientAuthenticationSuccessHandlerImpl patientAuthenticationSuccessHandlerImpl;
		
		@Autowired
		AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;
		
		@Autowired
		LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;
		
		@Autowired
		@Qualifier("doctorUserServiceImpl")
		UserDetailsService userDetailsService;
		
//		@Bean
//		public PasswordEncoder passwordEncoder(){
//			PasswordEncoder encoder = new BCryptPasswordEncoder(11);
//			return encoder;
//		}
		
		@Autowired
		PasswordEncoder passwordEncoder;
		
	

		@Override
	    protected void configure(HttpSecurity http) throws Exception {
//			.csrf()
//	    	.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//	    	.and()
	        http.csrf().disable()
	        		.cors() // cors config.
	        		.and()
	        		//.requestMatchers("/stanDomain/doctor*","/stanDomain/doctor*/*")
	        	.requestMatchers().antMatchers("/stanDomain/doc*","/stanDomain/doc*/*","/stanDomain/doc*/*/*")
	        	.and()
	            .authorizeRequests()
	            	//.antMatchers("/stanDomain/doctor*").permitAll()
//	                .antMatchers("/doctorUsers", "/drugOrders", "/MRI_EMR").permitAll()
//	                .antMatchers("/OutPatientEMR","/patientUsers", "/pharmacy").permitAll()
//	                .antMatchers("/orders", "/orders/*").hasAnyRole("USER", "ADMIN")
//	                .antMatchers("/users", "/users/*").hasAnyRole("ADMIN")
	                .and()
	            .exceptionHandling().authenticationEntryPoint(authenticationEntryPointImpl)
	                .and()
	            .exceptionHandling().accessDeniedHandler(accessDeniedHandlerImpl)
	                .and()
	            .formLogin()
					.permitAll()
					.loginProcessingUrl("/stanDomain/doctorLogin")
					.successHandler(doctorAuthenticationSuccessHandlerImpl)
				    .failureHandler(authenticationFailureHandlerImpl)
					.usernameParameter("username").passwordParameter("password")
					.and()
				.logout()
					.permitAll()
					.logoutUrl("/stanDomain/doctorLogout")
					.logoutSuccessHandler(logoutSuccessHandlerImpl)
					.deleteCookies("JSESSIONID")
					.and()
				.rememberMe();
	    }
		

		
		/*
		 * in memory user
		 */
//		@Bean
//		public UserDetailsService userDetailsService() {
//		    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		    manager.createUser(User.withUsername("rshi").password("123456").roles("USER").build());
//		    manager.createUser(User.withUsername("admin").password("123456").roles("USER","ADMIN").build());
//		    return manager;
//		}
		

		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
		    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		}
	}
	
	
	
	
	
	
	@Configuration
	@Order(2)
	public static class PatientConfigurationAdapter extends WebSecurityConfigurerAdapter {
		@Autowired
		AuthenticationEntryPointImpl authenticationEntryPointImpl;
		
		@Autowired
		AccessDeniedHandlerImpl accessDeniedHandlerImpl;
		
		@Autowired
		PatientAuthenticationSuccessHandlerImpl patientAuthenticationSuccessHandlerImpl;
		
		@Autowired
		AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;
		
		@Autowired
		LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;
		
		@Autowired
		@Qualifier("patientUserServiceImpl")
		UserDetailsService userDetailsService;
		
		@Autowired
		PasswordEncoder passwordEncoder;

		@Override
	    protected void configure(HttpSecurity http) throws Exception {
//			.csrf()
//	    	.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//	    	.and()
	        http.csrf().disable()
	        		.cors() // cors config.
	        		.and()
	        	.requestMatchers().antMatchers("/stanDomain/pat*","/stanDomain/pat*/*","/stanDomain/pat*/*/*")
	        	.and()
	            .authorizeRequests()
//	            	.antMatchers("/index.html", "/bloodTestEMR", "/departments").permitAll()
//	                .antMatchers("/doctorUsers", "/drugOrders", "/MRI_EMR").permitAll()
//	                .antMatchers("/OutPatientEMR","/patientUsers", "/pharmacy").permitAll()
//	                .antMatchers("/orders", "/orders/*").hasAnyRole("USER", "ADMIN")
//	                .antMatchers("/users", "/users/*").hasAnyRole("ADMIN")
	                .and()
	            .exceptionHandling().authenticationEntryPoint(authenticationEntryPointImpl)
	                .and()
	            .exceptionHandling().accessDeniedHandler(accessDeniedHandlerImpl)
	                .and()
	            .formLogin()
					.permitAll()
					.loginProcessingUrl("/stanDomain/patientLogin")
					.successHandler(patientAuthenticationSuccessHandlerImpl)
				    .failureHandler(authenticationFailureHandlerImpl)
					.usernameParameter("username").passwordParameter("password")
					.and()
				.logout()
					.permitAll()
					.logoutUrl("/stanDomain/patientLogout")
					.logoutSuccessHandler(logoutSuccessHandlerImpl)
					.deleteCookies("JSESSIONID")
					.and()
				.rememberMe();
	    }
		

		
		
		/*
		 * in memory user
		 */
//		@Bean
//		public UserDetailsService userDetailsService() {
//		    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		    manager.createUser(User.withUsername("rshi").password("123456").roles("USER").build());
//		    manager.createUser(User.withUsername("admin").password("123456").roles("USER","ADMIN").build());
//		    return manager;
//		}
		

		//@Autowired
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
		    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		}
		

//		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//		}
	}
	
	
	
	

}
