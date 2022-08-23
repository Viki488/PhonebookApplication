package com.bikkadIt.service;

import java.util.List;

import com.bikkadIt.model.Contact;

public interface ContactService {
	
	boolean saveContact (Contact contact);
	
	List <Contact> getAllData ();
	
	Contact getById (Integer contactId);

}
