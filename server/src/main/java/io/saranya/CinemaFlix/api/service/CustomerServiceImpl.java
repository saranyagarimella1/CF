package io.saranya.CinemaFlix.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.saranya.CinemaFlix.api.entity.Customer;
import io.saranya.CinemaFlix.api.exception.BadRequestException;
import io.saranya.CinemaFlix.api.exception.EntityNotFoundException;
import io.saranya.CinemaFlix.api.repository.CustomerRepositor;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepositor repository;
	
	public List<Customer> findAll() {
		return repository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Customer findOne(String username) {
		Customer cus = repository.findOne(username);
		if(cus==null)
		{
			throw new EntityNotFoundException("Customer record not found");
		}
		return cus;
	}
	
	@Transactional
	public Customer create(Customer cus) {
		Customer existing = repository.findByEmail(cus.getEmail());
		if(existing != null)
		{
			throw new BadRequestException("Customer with this email already exists");
		}
		return repository.create(cus);
	}
	
	@Transactional
	public Customer update(String username, Customer cus) {
		Customer existing = repository.findOne(username);
		if(existing==null)
		{
			throw new EntityNotFoundException("Customer not found");
		}
		return repository.update(cus);
	}
	
	@Transactional
	public void delete(String username) {
		Customer existing = repository.findOne(username);
		if(existing==null)
		{
			throw new EntityNotFoundException("Customer not found");
		}
		repository.delete(existing);
	}

}
