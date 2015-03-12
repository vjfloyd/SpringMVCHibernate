package com.sistemas.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sistemas.spring.model.Person;

public class PersonDaoImpl implements PersonDao{

	private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("persona agregada!!, persona id"+p);
	}

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("persona modificada!!, persona id"+p);
		
	}

	@SuppressWarnings("uncheked")
	@Override
	public List<Person> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personaLista = session.createQuery("from Person").list();
		for (Person person : personaLista) {
			logger.info("person list::"+person);
		}
		return personaLista;
	}

	@Override
	public Person getPersonById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, id);
		return p;
	}

	@Override
	public void removePerson(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p =(Person) session.load(Person.class, id);
		if( p != null){
			session.delete(p);
		}
		logger.info("Person eliminada : " + p);
	}

	
	
	

}
