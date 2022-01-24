package com.supmti.ecommerceappspringboot.Jwt;

import com.supmti.ecommerceappspringboot.Exceptions.AuthException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil{


	@Value("${jwt.expiration-time}")
	private long expirationTime;

	@Value("${jwt.secret}")
	private String secret;




	//generate token for user
	public String generateToken(String subject, Map<String,Object> claims)  {
		return doGenerateToken(subject, expirationTime *60*1000,claims);
	}

	private String doGenerateToken(String subject,long expiration,Map<String,Object> claims) {
		return  Jwts.builder()
				.setSubject(subject)
				.setExpiration(new Date((new Date()).getTime() + expiration))
				.setIssuedAt(new Date())
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}


	public String validateTokenAndReturnSubject(String token) throws AuthException {
		try {
			return  Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("email").toString();

		} catch (SignatureException e) {
			throw new AuthException("Invalid JWT signature: {}");
		} catch (MalformedJwtException e) {
			throw new AuthException("Invalid JWT token: {}");
		} catch (ExpiredJwtException e) {
			throw new AuthException("JWT token is expired: {}");
		} catch (UnsupportedJwtException e) {
			throw new AuthException("JWT token is unsupported: {}");
		} catch (IllegalArgumentException e) {
			throw new AuthException("JWT claims string is empty: {}");
		}

	}

	public void setAuthenticationToken(String userName, String password, HttpServletRequest request) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userName, password, Collections.singletonList(new SimpleGrantedAuthority("ROLE-USER")));
		// Stores additional details about the authentication request (IP address, certificate serial number etc.).
		if(request!=null)
			usernamePasswordAuthenticationToken
					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		// After setting the Authentication in the context, we specify
		// that the current user is authenticated. So it passes the
		// Spring Security Configurations successfully.
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

	}
}
