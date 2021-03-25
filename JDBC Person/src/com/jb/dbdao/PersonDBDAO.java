package com.jb.dbdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jb.beans.Hobby;
import com.jb.beans.Person;
import com.jb.dao.PersonDAO;
import com.jb.db.DBUtils;

public class PersonDBDAO implements PersonDAO {
	private static final String QUERY_INSERT = "INSERT INTO PERSON (name, city, birthday, hobby) VALUES (?,?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE PERSON SET name= ?, city= ?, birthday= ?, hobby= ? WHERE id = ?";
	private static final String QUERY_DELETE = "DELETE FROM PERSON WHERE id = ?";
	private static final String QUERY_GET_ALL = "SELECT * FROM PERSON";
	private static final String QUERY_GET_ROW = "SELECT * FROM PERSON WHERE id = ?";

	@Override
	public void addPerson(Person person) throws SQLException, InterruptedException {
		Map<Integer, Object> map = new HashMap<>();
		map.put(1, person.getName());
		map.put(2, person.getCity());
		map.put(3, person.getBirthday());
		map.put(4, person.getHobby().name());
		DBUtils.runQueryWithResult(QUERY_INSERT, map);
	}

	@Override
	public void updatePerson(List<Person> person, int id) throws SQLException, InterruptedException {
		if (getSinglePerson(id).size() == 0) {
			System.out.println("0 rows updated.");
			return;
		}
		Map<Integer, Object> map = new HashMap<>();
		map.put(1, person.get(0).getName());
		map.put(2, person.get(0).getCity());
		map.put(3, person.get(0).getBirthday());
		map.put(4, person.get(0).getHobby().name());
		map.put(5, person.get(0).getId());
		DBUtils.runQueryWithResult(QUERY_UPDATE, map);

	}

	@Override
	public void deletePerson(int id) throws SQLException, InterruptedException {
		if (getSinglePerson(id).size() == 0) {
			System.out.println("0 rows deleted.");
			return;
		}
		Map<Integer, Object> map = new HashMap<>();
		map.put(1, id);
		DBUtils.runQueryWithResult(QUERY_DELETE, map);

	}

	@Override
	public List<Person> getAllPersons() throws SQLException, InterruptedException {
		Map<Integer, Object> map = new HashMap<>();
		List<Person> results = new ArrayList<>();
		ResultSet resultSet = DBUtils.runQueryWithResult(QUERY_GET_ALL, map);
		while (resultSet.next()) {
			Person person = new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDate(4), Hobby.valueOf(resultSet.getString(5)));
			results.add(person);
		}
		return results;
	}

	@Override
	public List<Person> getSinglePerson(int id) throws SQLException, InterruptedException {
		List<Person> result = new ArrayList<>();
		Map<Integer, Object> map = new HashMap<>();
		map.put(1, id);
		ResultSet resultSet = DBUtils.runQueryWithResult(QUERY_GET_ROW, map);
		boolean rowExists = resultSet.next();
		if (rowExists) {
			Person person = new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDate(4), Hobby.valueOf(resultSet.getString(5)));
			result.add(person);
		}
		return result;
	}

}
