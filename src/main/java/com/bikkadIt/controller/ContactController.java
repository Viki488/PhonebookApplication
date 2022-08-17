package com.bikkadIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIt.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactServcie;

}
