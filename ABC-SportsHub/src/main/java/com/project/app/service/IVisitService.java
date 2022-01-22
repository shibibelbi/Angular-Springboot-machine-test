package com.project.app.service;

import java.util.List;
import java.util.Optional;

import com.project.app.model.Visit;

public interface IVisitService {

	// visit all Employee
	public List<Visit> getAllVisits();

	// get Employee Visit by id
	public Optional<Visit> getVisitById(Integer id);

	// add employee visit
	public void addVisit(Visit visit);

	// update the visits of Employee
	public void updateVisit(Visit visit);

	// delete the employee visits
	public void deleteVisit(Integer id);

}
