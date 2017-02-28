package io.saranya.CinemaFlix.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.saranya.CinemaFlix.api.entity.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositor{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer findOne(String username) {
		return em.find(Customer.class, username);
	}

	@Override
	public Customer create(Customer cus) {
		em.persist(cus);
		return cus;
	}

	@Override
	public Customer findByEmail(String email) {
		TypedQuery<Customer> query = em.createNamedQuery("Customer.findByEmail", Customer.class);
		query.setParameter("pEmail", email);
		
		List<Customer> customers = query.getResultList();
		if(customers != null && customers.size() == 1)
			return customers.get(0);
		else 
			return null;
	}

	@Override
	public Customer update(Customer cus) {
		return em.merge(cus);
	}

	@Override
	public void delete(Customer cus) {
		em.remove(cus);
		
	}

	
}
