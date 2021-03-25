package com.jb;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import com.jb.beans.Hobby;
import com.jb.beans.Person;
import com.jb.dao.PersonDAO;
import com.jb.db.ConnectionPool;
import com.jb.db.DBUtils;
import com.jb.db.DatebaseManager;
import com.jb.db.FactoryPerson;
import com.jb.dbdao.PersonDBDAO;

public class Test {
	static PersonDAO personDAO = new PersonDBDAO();

	public static void main(String[] args) throws SQLException, InterruptedException {

		DatebaseManager.dropAndCreate();
		List<Person> persons = FactoryPerson.initList();
		for (Person person : persons) {
			personDAO.addPerson(person);
		}

		List<Person> toUpdate = personDAO.getSinglePerson(1);
		if (toUpdate.size() > 0) {
			toUpdate.get(0).setName("bbababa");
			toUpdate.get(0).setCity("dadad");
			toUpdate.get(0).setBirthday(new GregorianCalendar(1790, 0, 1).getTime());
			toUpdate.get(0).setHobby(Hobby.PAINTING);
		}
		personDAO.updatePerson(toUpdate, 1);

		DBUtils.printQuery(personDAO.getSinglePerson(2));
		personDAO.deletePerson(1);
		DBUtils.printQuery(personDAO.getAllPersons());

		ConnectionPool.getInstance().closeAllConnection();
	}

}
