package com.project.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.model.Visit;
import com.project.app.service.IVisitService;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class VisitController {

	// get instance --IOC
	@Autowired
	private IVisitService visitService;

	// get employee visit
	@GetMapping("/visits")
	public List<Visit> getAllVisits() {
		return (List<Visit>) visitService.getAllVisits();
	}

	// get employee visit by id
	@GetMapping("/visits/{id}")
	public Optional<Visit> getVisitById(@PathVariable Integer id) {
		return visitService.getVisitById(id);
	}

	// post --insert list of employee visit
	@PostMapping("/visits")
	public void addVisit(@RequestBody Visit visit) {
		visitService.addVisit(visit);

	}

	// put --update employee visit
	@PutMapping("/visits")
	public void update(@RequestBody Visit visit) {
		visitService.updateVisit(visit);

	}

	// delete employee visit by id
	@DeleteMapping("/visits/{id}")
	public void deleteVisit(@PathVariable Integer id) {
		visitService.deleteVisit(id);
	}

}
