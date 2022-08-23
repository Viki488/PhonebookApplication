package com.bikkadIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIt.model.Contact;
import com.bikkadIt.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactServcie;
	
	@PostMapping (value="/saveContact",consumes="application/json")
	public ResponseEntity<String>saveContact (@RequestBody Contact contact){
		boolean saveContact = contactServcie.saveContact(contact);
		if(saveContact==true) {
			String msg ="Contact Sucessfully Saved";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
			
		}else {
		String msg1="Contact not saved";
		return new ResponseEntity<String>(msg1,HttpStatus.BAD_REQUEST)  ;
		
		}
	}
	@GetMapping(value="/getAllContact",produces="application/json")
	public ResponseEntity<List<Contact>> getAllContact (){
		List<Contact> getalldata = this.contactServcie.getAllData();

		return new ResponseEntity<List<Contact>>(getalldata,HttpStatus.OK);	
	}
    @GetMapping (value="/getById/{contactId}",produces="application/json")
	public ResponseEntity<Contact> getById (@PathVariable Integer contactId){
		Contact getbyId = contactServcie.getById(contactId);
		
		return new ResponseEntity<Contact>(getbyId,HttpStatus.OK);
		
	}
}
