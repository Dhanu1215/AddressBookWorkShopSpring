package com.example.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressbook.model.AddressBookData;

public interface IAddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}
