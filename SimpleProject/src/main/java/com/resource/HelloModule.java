package com.resource;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Module;

public class HelloModule extends AbstractModule{
	@Override
	public void configure() {
		bind(HelloResources.class);
		bind(Hello.class).to(HelloImpl.class);
	}
}
