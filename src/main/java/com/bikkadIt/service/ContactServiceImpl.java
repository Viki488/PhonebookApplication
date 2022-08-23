package com.bikkadIt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadIt.model.Contact;
import com.bikkadIt.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
 private ContactRepo contactRepo ;

	@Override
	public boolean saveContact(Contact contact) {
		Contact save = contactRepo.save(contact);
		
		if(save!=null) {
			return true;
		}else {
		return false;
	}
	
	}

	@Override
	public List<Contact> getAllData() {
		List<Contact> findAll = contactRepo.findAll();
		return findAll;
	}

	@Override
	public Contact getById(Integer contactId) {
		Contact contact = contactRepo.findById(contactId).get();
		return contact;
	}

	@Override
	public boolean updateContact(Contact contact) {
		Contact updateContact = contactRepo.save(contact);
		if (updateContact==null) {
			return  false;
		}else {
		return true;
	}

	}
	
	
	
}
