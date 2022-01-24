package com.supmti.ecommerceappspringboot.Jwt;

import com.supmti.ecommerceappspringboot.Exceptions.AuthException;
import com.supmti.ecommerceappspringboot.Models.User;
import com.supmti.ecommerceappspringboot.Repositories.UserRepository;
import com.supmti.ecommerceappspringboot.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
@AllArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {



	private  JwtTokenUtil jwtTokenUtil;
	private UserService userService;


/*	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String reqUri=request.getRequestURI();
		return !reqUri.contains("userOrders") && !reqUri.contains("appUsers") && !reqUri.contains("creditCards");
	}*/

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String authHeader=request.getHeader("Authorization");
		 if(authHeader!=null) {
			 // JWT Token is in the form "Bearer token". Remove Bearer word and get
			 // only the Token
			 String[] tokenArr = authHeader.split("Bearer ");
			 if (tokenArr.length != 2)
				 throw new AuthException("Header not contains Authorization or JWT Token does not begin with Bearer");

	/*		response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpStatus.BAD_REQUEST.value());*/

			 // Once we get the token validate it.
			 if (SecurityContextHolder.getContext().getAuthentication() == null) {
				 try {
					 String email = jwtTokenUtil.validateTokenAndReturnSubject(tokenArr[1]);
					 User user = userService.getByEmail(email);

					 if (user != null) {
						 // set authentication to spring security context
						 jwtTokenUtil.setAuthenticationToken(user.getEmail(), user.getPassword(), request);
					 }
				 } catch (AuthException ex) {
					 response.sendError(HttpStatus.FORBIDDEN.value(), ex.getMessage());
				 }

			 }
		 }
		chain.doFilter(request, response);

	}
}