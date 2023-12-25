package com.zohocrmapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService{
	
	@Autowired
	private LeadRepository leadrepo;

	@Override
	public void saveOneLead(Lead lead) {
		leadrepo.save(lead);
		
	}

	@Override
	public Lead getOneLeadById(long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteByid(long id) {
		leadrepo.deleteById(id);
		
	}

	@Override
	public List<Lead> listLeads() {
		List<Lead> lead = leadrepo.findAll();
		return lead;
	}
	
	

}
