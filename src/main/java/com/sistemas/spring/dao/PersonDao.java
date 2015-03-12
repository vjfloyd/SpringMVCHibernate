package com.sistemas.spring.dao;

import java.util.List;

import com.sistemas.spring.model.Person;

public interface PersonDao {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> list();
	public Person getPersonById(Integer id);
	public void removePerson(Integer id);
	
}
