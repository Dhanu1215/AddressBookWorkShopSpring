package com.example.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.addressbook.model.AddressBookData;

@Repository
public interface IAddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}
