package com.stan.HospitalInfoDemo.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stan.HospitalInfoDemo.beans.DoctorUser;
import com.stan.HospitalInfoDemo.beans.PatientUser;
import com.stan.HospitalInfoDemo.http.DoctorAuthenticationSuccessResponse;
import com.stan.HospitalInfoDemo.http.PatientAuthenticationSuccessResponse;
import com.stan.HospitalInfoDemo.http.Response;

public class PatientSecurityUtils {
	
	private static final ObjectMapper mapper = new ObjectMapper();

	public static void sendResponse(HttpServletResponse httpServletResponse, int status, String message, Exception exception)
			throws IOException {
		Response response = new Response(exception == null ? true : false, status, message);
		flushResponse(httpServletResponse, response);
	}
	
	public static void sendAuthenticationSuccessResponse(HttpServletResponse httpServletResponse, int status, String message, Exception exception, PatientUser patientUser)
			throws IOException {
		Response response = new PatientAuthenticationSuccessResponse(exception == null ? true : false, status, message, patientUser);
		System.out.println(response);
		flushResponse(httpServletResponse, response);
	}

	public static void flushResponse(HttpServletResponse httpServletResponse, Response response) throws IOException {
		httpServletResponse.setContentType("application/json;charset=UTF-8");
		httpServletResponse.setStatus(response.getCode());
		PrintWriter writer = httpServletResponse.getWriter();
		writer.write(mapper.writeValueAsString(response));
		writer.flush();
		writer.close();
	}
	
	public static boolean isAdmin(Collection<? extends GrantedAuthority> profiles) {
		boolean isAdmin = false;
		for(GrantedAuthority profle: profiles) {
			if(profle.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
			}
		};
		return isAdmin;
	}
	
	public static boolean isGuest(Collection<? extends GrantedAuthority> profiles) {
		boolean isGuest = false;
		for(GrantedAuthority profle: profiles) {
			if(profle.getAuthority().equals("ROLE_GUEST")) {
				isGuest = true;
			}
		};
		return isGuest;
	}

}
