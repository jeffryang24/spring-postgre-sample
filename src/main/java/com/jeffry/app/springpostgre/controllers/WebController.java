package com.jeffry.app.springpostgre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeffry.app.springpostgre.models.CustomerModel;
import com.jeffry.app.springpostgre.repositories.CustomerRepository;

@RestController
public class WebController {
	
	@Autowired
	CustomerRepository repo;
	
	@RequestMapping(value = "/save")
	public String process() {
		repo.save(new CustomerModel("Jack", "Sparrow"));
		repo.save(new CustomerModel("Tom", "Hank"));
		return "Done";
	}
	
	@RequestMapping(value = "/findall")
	public String findAll() {
		String result = "<html>";
		for (CustomerModel cust : repo.findAll()) {
			result += "<div>" + cust.toString() + "</div>";
		}
		return result + "</html>";
	}
	
	@RequestMapping(value = "/findbyid")
	public String findById(@RequestParam(value = "id") long id) {
		String result = repo.findOne(id).toString();
		return result;
	}
	
	@RequestMapping(value = "/findbylastname")
	public String fetchDataByLastName(@RequestParam(value = "lastname") String lastName) {
		String result = "<html>";
		for (CustomerModel cust : repo.findByLastName(lastName)) {
			result += "<div>" + cust.toString() + "</div>";
		}
		return result + "</html>";
	}
}
