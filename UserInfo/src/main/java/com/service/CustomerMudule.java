package com.service;

import com.google.inject.AbstractModule;

public class CustomerMudule extends AbstractModule{
	@Override
	public void configure() {
		bind(CustomerResource.class);
		bind(CustomerService.class).to(CustomerServiceImpl.class);
	}

}
