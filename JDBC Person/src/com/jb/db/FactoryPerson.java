package com.jb.db;

import com.jb.beans.Hobby;
import com.jb.beans.Person;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class FactoryPerson {

	public static List<Person> initList() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("Kobi", "Tel Aviv", new GregorianCalendar(1966, 11, 1).getTime(), Hobby.SPORT));
		list.add(new Person("Lora", "Holon", new GregorianCalendar(2021, 2, 25).getTime(), Hobby.NETFLIX));
		list.add(new Person("Ronit", "Netanya", new GregorianCalendar(2002, 2, 2).getTime(), Hobby.NETFLIX));
		list.add(new Person("Avi", "Eilat", new GregorianCalendar(1982, 7, 30).getTime(), Hobby.PS5));
		list.add(new Person("Paz", "Caesarea", new GregorianCalendar(1999, 10, 28).getTime(), Hobby.TENNIS));
		list.add(new Person("Joni", "London", new GregorianCalendar(1986, 8, 11).getTime(), Hobby.PC));
		list.add(new Person("Shira", "Haifa", new GregorianCalendar(2005, 5, 18).getTime(), Hobby.COOKING));
		list.add(new Person("Tzach", "Rishon LeZion", new GregorianCalendar(1900, 11, 30).getTime(), Hobby.PS5));
		list.add(new Person("Dani", "Zefat", new GregorianCalendar(1945, 4, 2).getTime(), Hobby.FOOTBALL));
		list.add(new Person("Sapir", "Bangkok", new GregorianCalendar(1991, 10, 29).getTime(), Hobby.PAINTING));
		list.add(new Person("Ben", "Rio de Janeiro", new GregorianCalendar(1995, 3, 4).getTime(), Hobby.SPORT));
		return list;
	}
}
