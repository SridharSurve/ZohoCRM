package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.services.ContactService;
import com.zohocrmapp.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadserv;
	
	@Autowired
	private ContactService contactserv;
	

	@RequestMapping("/")
	public String viewCreateLeadPage()
	{
		return"create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String SaveLead(@ModelAttribute("lead") Lead lead , ModelMap model)
	{
		leadserv.saveOneLead(lead);
		model.addAttribute("lead", lead);
		return"lead_info";
	}
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id , ModelMap model)
	{
		Lead lead = leadserv.getOneLeadById(id);
		Contact contact= new Contact();
		contact.setFirstNmae(lead.getFirstNmae());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contactserv.saveContact(contact);
		leadserv.deleteByid(id);
		List<Contact> contacts = contactserv.listContacts();
		model.addAttribute("contacts", contacts);
		return"search_contact_info";
	}
	
	@RequestMapping("/listall")
	public String listAllLeads(ModelMap model)
	{
		List<Lead> lead = leadserv.listLeads();
		model.addAttribute("lead", lead);
		return"search_lead_result";
	}
	
	@RequestMapping("/lead_info")
	public String leadInfo(@RequestParam("id") long id , ModelMap model)
	{
		Lead lead = leadserv.getOneLeadById(id);
		model.addAttribute("lead", lead);
		return"lead_info";
	}
	
}
