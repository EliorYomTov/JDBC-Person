package com.jb.dao;

import java.sql.SQLException;
import java.util.List;

import com.jb.beans.Person;

public interface PersonDAO {

	void addPerson(Person person) throws SQLException, InterruptedException;

	void updatePerson(List<Person> person, int id) throws SQLException, InterruptedException;

	void deletePerson(int id) throws SQLException, InterruptedException;

	List<Person> getAllPersons() throws SQLException, InterruptedException;

	List<Person> getSinglePerson(int id) throws SQLException, InterruptedException;
}
