package io.saranya.CinemaFlix.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.saranya.CinemaFlix.api.entity.Customer;
import io.saranya.CinemaFlix.api.service.CustomerService;

@RestController
@RequestMapping(value="customers")
public class CustomerController {
@Autowired
	private CustomerService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Customer> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{username}")
	public Customer findOne(@PathVariable("username") String username){
		return service.findOne(username);
	}
	
@RequestMapping(method=RequestMethod.POST)
	
	public Customer create(@RequestBody Customer cus){
		return service.create(cus);
	}
	
@RequestMapping(method = RequestMethod.PUT, value = "{username}")
public Customer update(@PathVariable("username") String username, @RequestBody Customer cus) {

    return service.update(username, cus);
}

@RequestMapping(method=RequestMethod.DELETE, value="{username}")

public void delete(@PathVariable("username") String username){
	service.delete(username);
}
	
}