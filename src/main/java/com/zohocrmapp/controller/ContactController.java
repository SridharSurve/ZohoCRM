package com.zohocrmapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactserv;
	
	@RequestMapping("/listallContacts")
	public String listAllContacts(ModelMap model)
	{
		List<Contact> contacts = contactserv.listContacts();
		model.addAttribute("contacts", contacts);
		return"search_contact_info";
	}
	
	@RequestMapping("/contact_info")
	public String contactInfo(@RequestParam("id") long id , ModelMap model)
	{
		Contact contact = contactserv.getOneContact(id);
		model.addAttribute("contact", contact);
		return"contact_info";
	}
}
