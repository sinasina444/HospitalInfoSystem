package com.stan.HospitalInfoDemo.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.stan.HospitalInfoDemo.beans.PatientUser;
import com.stan.HospitalInfoDemo.security.PatientSecurityUtils;

@Component
public class PatientAuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler{
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		PatientSecurityUtils.sendAuthenticationSuccessResponse(response, HttpServletResponse.SC_OK, "Login successfully.", null, (PatientUser)authentication.getPrincipal());
		
		
		System.out.println("###request: " + request.toString() + "; response.getLocale: " + response.getLocale()
		+ "response: " + response);
		System.out.println("###function: onAuthenticationSuccess: authentication.getAuthorities()" + authentication.getAuthorities()
			+"; getCredentials: " + authentication.getCredentials() + "; getDetails: " + authentication.getDetails());
	}
}
