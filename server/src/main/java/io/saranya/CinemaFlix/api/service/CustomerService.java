package io.saranya.CinemaFlix.api.service;

import java.util.List;

import io.saranya.CinemaFlix.api.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	public Customer findOne(String id);
	public Customer create(Customer cus);
	public Customer update(String id, Customer cus);
	public void delete(String id);

}
