package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// create a query
		Query<Customer> theQuery = session.createQuery("from Customer order by lastname", Customer.class);
		// exequte query and get result list
		List<Customer> customers = theQuery.getResultList();
		// return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomers(int theId) {

		Session session=sessionFactory.getCurrentSession();
		Customer theCustomer=session.get(Customer.class,theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		Session session=sessionFactory.getCurrentSession();
		Query theQuery=session.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
		
	}

}
