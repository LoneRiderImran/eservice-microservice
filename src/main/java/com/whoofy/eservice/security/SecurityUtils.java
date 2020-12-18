package com.whoofy.eservice.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class SecurityUtils {

	/**
	 * @GET get current login of user
	 * 
	 * @return current user login
	 */
	public static String getCurrentUser() {
		Optional<String> currentUser = SecurityUtils.getCurrentUserLogin();
		if (currentUser.isPresent()) {
			return currentUser.get();
		} else {
			throw new UsernameNotFoundException("Invalid User");
		}
	}

	/**
	 * @GET Get the login of the current user.
	 *
	 * @return the login of the current user
	 */
	public static Optional<String> getCurrentUserLogin() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		return Optional.ofNullable(securityContext.getAuthentication()).map(authentication -> {
			if (authentication.getPrincipal() instanceof UserDetails) {
				UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
				return springSecurityUser.getUsername();
			} else if (authentication.getPrincipal() instanceof String) {
				return (String) authentication.getPrincipal();
			}
			return null;
		});
	}

}
