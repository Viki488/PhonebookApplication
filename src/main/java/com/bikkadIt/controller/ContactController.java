package com.bikkadIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @PutMapping(value="/updateContact",consumes="application/json")
    public ResponseEntity<String> updateContact (@RequestBody Contact contact) {
    	boolean updateContact = contactServcie.updateContact(contact);
    	
    	if(updateContact==true) {
    		
    		String msg="Conatact update Successfull";
    		
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}else {
    	
    	String msg1="Contact not Updated";
		return new ResponseEntity<String>(msg1,HttpStatus.BAD_REQUEST);
    	
    	}
    }
    @DeleteMapping(value="/HarddeleteById/{contactId}")
    public ResponseEntity<String> HarddeleteById (@PathVariable Integer contactId){
    	boolean hardDeleteById = contactServcie.HardDeleteById(contactId);
    	if(hardDeleteById) {
    		String msg="Conatact Deleted Successfully";
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}else {
    		String msg1="Given ContactId not matach to Database ";
		return new  ResponseEntity<String>(msg1,HttpStatus.BAD_REQUEST);
    	}	
    }
    @DeleteMapping(value="/softdDelelteById/{contactId}")
    public  ResponseEntity<String> softdDelelteById (@PathVariable Integer contactId){
    	boolean softDeleteById = contactServcie.softDeleteById(contactId);
    	if(softDeleteById) {
    		String msg="Contact Deleted Successfully";
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}else {
   
    		String msg1="Given ContactId not matach to Database ";
    		return new  ResponseEntity<String>(msg1,HttpStatus.BAD_REQUEST);
    		
    	}
		
    	
    }
}
