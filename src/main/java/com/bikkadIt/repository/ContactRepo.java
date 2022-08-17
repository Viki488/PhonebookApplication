package com.bikkadIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadIt.model.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
