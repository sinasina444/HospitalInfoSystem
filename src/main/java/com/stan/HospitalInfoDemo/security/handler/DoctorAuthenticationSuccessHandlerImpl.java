package com.stan.HospitalInfoDemo.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.security.DoctorSecurityUtils;


@Component
public class DoctorAuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		DoctorSecurityUtils.sendAuthenticationSuccessResponse(response, HttpServletResponse.SC_OK, "Login successfully.", null, (DoctorUser)authentication.getPrincipal());
		
		
		System.out.println("###request: " + request.toString() + "; response.getLocale: " + response.getLocale()
		+ "response: " + response);
		System.out.println("###function: onAuthenticationSuccess: authentication.getAuthorities()" + authentication.getAuthorities()
			+"; getCredentials: " + authentication.getCredentials() + "; getDetails: " + authentication.getDetails());
	}
	
}
