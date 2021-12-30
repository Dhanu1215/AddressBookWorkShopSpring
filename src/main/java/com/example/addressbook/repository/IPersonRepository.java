package com.example.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressbook.model.PersonData;

public interface IPersonRepository extends JpaRepository<PersonData, Integer> {

}
