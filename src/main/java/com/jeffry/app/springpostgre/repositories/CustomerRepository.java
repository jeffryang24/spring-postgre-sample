package com.jeffry.app.springpostgre.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeffry.app.springpostgre.models.CustomerModel;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {
	List<CustomerModel> findByLastName(String lastName);
}
