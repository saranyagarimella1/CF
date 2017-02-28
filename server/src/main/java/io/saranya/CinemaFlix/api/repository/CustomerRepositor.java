package io.saranya.CinemaFlix.api.repository;

import java.util.List;

import io.saranya.CinemaFlix.api.entity.Customer;

public interface CustomerRepositor {

	public List<Customer> findAll();
	public Customer findOne(String username);
	public Customer create(Customer cus);
	
	public Customer findByEmail(String email);
	public Customer update(Customer cus);
	public void delete(Customer cus);
}
