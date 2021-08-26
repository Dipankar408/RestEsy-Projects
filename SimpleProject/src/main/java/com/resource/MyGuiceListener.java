package com.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class MyGuiceListener extends GuiceResteasyBootstrapServletContextListener{

	@Override
    protected List<? extends Module> getModules(ServletContext context)
    {
        return Arrays.asList(new JpaPersistModule("punit"), new HelloModule());
    }
    
    @Override
    public void withInjector(Injector injector)
    {
        injector.getInstance(PersistService.class).start();
    }
}
