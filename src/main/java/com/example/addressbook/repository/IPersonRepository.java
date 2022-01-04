package com.example.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.addressbook.model.PersonData;

@Repository
public interface IPersonRepository extends JpaRepository<PersonData, Integer> {

}
