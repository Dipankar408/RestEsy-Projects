package com.service;

import java.util.List;

import com.db.Customer;

public interface CustomerService {
	public void createCustomer(int id,String name,int age,String num,long pin,String city,String distric,String state);
	
	public List<Object> showAllCustomer();
	public List<Object> showNumbers();
}
