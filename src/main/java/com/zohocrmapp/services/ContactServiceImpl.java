package com.zohocrmapp.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	
	@Autowired
	private ContactRepository contactrepo;

	@Override
	public void saveContact(Contact contact) {
		contactrepo.save(contact);
		
	}

	@Override
	public List<Contact> listContacts() {
		List<Contact> contacts = contactrepo.findAll();
		return contacts;
	}

	@Override
	public Contact getOneContact(long id) {
		Optional<Contact> findById = contactrepo.findById(id);
		Contact contact = findById.get();
		return contact;
	}


}
