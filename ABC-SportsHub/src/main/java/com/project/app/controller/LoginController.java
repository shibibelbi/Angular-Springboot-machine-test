package com.project.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.model.Login;
import com.project.app.service.ILoginService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {

	// get instance --IOC
	@Autowired
	private ILoginService loginService;

	// http Methods
	// get All login of users
	@GetMapping("/logins")
	public List<Login> getAllLogins() {
		return (List<Login>) loginService.getAllLogins();
	}

	// get login by user id
	@GetMapping("/logins/{id}")
	public Optional<Login> getLoginById(@PathVariable Integer id) {
		return loginService.getLoginById(id);
	}

	// Post --insert user by login
	@PostMapping("/logins")
	public void addLogin(@RequestBody Login login) {
		loginService.addLogin(login);

	}

	// Put --update user login Page
	@PutMapping("/logins")
	public void updateLogin(@RequestBody Login login) {
		loginService.updateLogin(login);

	}

	// delete login by userId
	@DeleteMapping("/logins/{id}")
	public void deleteLogin(@PathVariable Integer id) {
		loginService.deleteLogin(id);

	}

	// path variable for login page
	@GetMapping("/login/{username}&{password}")
	public ResponseEntity<Login> getLoginByLoginNameAndPassword(@PathVariable String username,
			@PathVariable String password) {

		ResponseEntity<Login> response = null;

		Login login = loginService.getLoginByLoginNameAndPassword(username, password);

		if (login == null) {
			response = new ResponseEntity<>(login, HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(login, HttpStatus.OK);
		}
		return response;
	}

}
