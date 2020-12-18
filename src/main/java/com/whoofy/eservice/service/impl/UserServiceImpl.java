package com.whoofy.eservice.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.whoofy.eservice.domain.Role;
import com.whoofy.eservice.domain.User;
import com.whoofy.eservice.repository.UserRepository;
import com.whoofy.eservice.rest.dto.UserDto;
import com.whoofy.eservice.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findById(String id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setAge(user.getAge());
		newUser.setSalary(user.getSalary());
		Role role = new Role();
		role.setName("USER");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		newUser.setRoles(roles);
		return userRepository.save(newUser);
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
