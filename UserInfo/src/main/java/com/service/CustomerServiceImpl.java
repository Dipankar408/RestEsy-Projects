package com.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.db.Address;
import com.db.Customer;
import com.db.Password;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public class CustomerServiceImpl implements CustomerService {

	@Inject
	Provider<EntityManager> emp;
	
	@Override
	@Transactional
	public void createCustomer(int id,String name,int age,String num,long pin,String city,String distric,String state,String pass) {
		EntityManager em=emp.get();
		Customer c=new Customer();
		c.setId(id);
		c.setName(name);
		c.setAge(age);
		c.setNumber(num);
		Address adr=null;
		Query q=em.createQuery("Select a from Address a where a.pincode="+pin);
		try {
			adr=(Address) q.getSingleResult();
		}
		catch(Exception e){
			
		}
		if(adr!=null) {
			c.setAdr(adr);
		}
		else {
			Address a=new Address();
			a.setPincode(pin);
			a.setCity(city);
			a.setDistrict(distric);
			a.setState(state);
			
			c.setAdr(a);
			em.persist(a);
		}
	
		Password pw=new Password();
		pw.setPassword(pass);
		pw.setC(c);
		
		em.persist(pw);
		
		em.persist(c);
		

	}

	@Override
	@Transactional
	public List<Object> showAllCustomer() {
		EntityManager em=emp.get();
		Query q=em.createQuery("Select c from Customer c,Address a where c.adr=a.pincode order by c.id asc");
		List<Object> clist=q.getResultList();
		return clist;
	}
	
	@Override
	@Transactional
	public List<Object> showNumbers(){
		EntityManager em=emp.get();
		Query q1=em.createQuery("Select ct from Customer c,Contact ct where c.id=ct.ct order by c.id asc");
		List<Object> clist=q1.getResultList();
		return clist;
	}

	@Override
	@Transactional
	public boolean login(int id,String pass) {
		EntityManager em=emp.get();
		Password pw=null;
		Query q=em.createQuery("Select p from Password p where p.c="+id+" and p.password='"+pass+"'");
		try {
			pw=(Password) q.getSingleResult();
		}catch(Exception e) {
			
		}
		if(pw!=null) {
			return true;
		}
			return false;
		
	}

}
