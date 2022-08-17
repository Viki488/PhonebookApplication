package com.bikkadIt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadIt.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
 private ContactRepo contactRepo ;
	
	
}
