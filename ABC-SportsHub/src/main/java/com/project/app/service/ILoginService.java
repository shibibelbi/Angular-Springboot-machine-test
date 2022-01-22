package com.project.app.service;

import java.util.List;
import java.util.Optional;

import com.project.app.model.Login;

public interface ILoginService {

	// get all Login
	public List<Login> getAllLogins();

	// get login by id
	public Optional<Login> getLoginById(Integer id);

	// add login of user
	public void addLogin(Login login);

	// update login of user
	public void updateLogin(Login login);

	// delete an user login
	public void deleteLogin(Integer id);

	public Login getLoginByLoginNameAndPassword(String username, String password);

}
