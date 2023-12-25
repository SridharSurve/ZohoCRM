package com.zohocrmapp.services;

import java.util.List;

import com.zohocrmapp.entities.Lead;

public interface LeadService {

	public void saveOneLead(Lead lead);
	public Lead getOneLeadById(long id);
	public void deleteByid(long id);
	public List<Lead> listLeads();
	
}
