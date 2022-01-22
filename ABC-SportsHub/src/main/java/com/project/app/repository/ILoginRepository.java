package com.project.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.app.model.Login;

@Repository
public interface ILoginRepository extends CrudRepository<Login, Integer> {
	// Custom QueryMethod --JPARepository
	@Query("FROM Login WHERE username=?1 AND password=?2")
	Login findByUsernameAndPassword(String username, String password);

}
