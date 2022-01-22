package com.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.model.Login;
import com.project.app.repository.ILoginRepository;

@Service
public class LoginServiceImp implements ILoginService {

	@Autowired
	private ILoginRepository loginRepository;

	// Login the user
	@Override
	public List<Login> getAllLogins() {

		return (List<Login>) loginRepository.findAll();
	}

	// Login by username
	@Override
	public Optional<Login> getLoginById(Integer id) {

		return loginRepository.findById(id);
	}

	// add login for a user
	@Override
	public void addLogin(Login login) {
		loginRepository.save(login);

	}

	// update login for user
	@Override
	public void updateLogin(Login login) {
		loginRepository.save(login);

	}

	// delete login of user
	@Override
	public void deleteLogin(Integer id) {
		loginRepository.deleteById(id);
	}

	// get login by using username and password
	@Override
	public Login getLoginByLoginNameAndPassword(String username, String password) {
		return loginRepository.findByUsernameAndPassword(username, password);
	}

}
