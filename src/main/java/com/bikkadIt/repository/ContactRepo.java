package com.bikkadIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadIt.model.Contact;
@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
