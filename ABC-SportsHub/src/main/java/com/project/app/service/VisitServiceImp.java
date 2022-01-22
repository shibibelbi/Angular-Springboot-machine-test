package com.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.model.Visit;
import com.project.app.repository.IVisitRepository;

@Service
public class VisitServiceImp implements IVisitService {
	@Autowired
	private IVisitRepository visitRepository;

	// visit employee
	@Override
	public List<Visit> getAllVisits() {
		return (List<Visit>) visitRepository.findAll();
	}

	// visit employee by Id
	@Override
	public Optional<Visit> getVisitById(Integer id) {

		return visitRepository.findById(id);
	}

	// add visit employee
	@Override
	public void addVisit(Visit visit) {
		visitRepository.save(visit);

	}

	// update visit employee
	@Override
	public void updateVisit(Visit visit) {
		visitRepository.save(visit);
	}

	// delete visit employee by id
	@Override
	public void deleteVisit(Integer id) {
		visitRepository.deleteById(id);
	}

}
