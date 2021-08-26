package com.resource;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.db.Student;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import org.jboss.resteasy.plugins.providers.html.View;

@Singleton
public class HelloImpl implements Hello {
	@Inject
	Provider<EntityManager> emp; 
	
	

	@Override
	@Transactional
	public List<Student> displayStudent() {
		EntityManager em=emp.get();
		Query query =  (Query) em.createQuery("Select s from Student s order by s.id asc");
		List<Student> stdList = (List<Student>)query.getResultList();
		return stdList;
	}

}
