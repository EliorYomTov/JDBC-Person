package com.jb.beans;

import java.util.Date;

public class Person {
	private int id;
	private String Name;
	private String city;
	private Date birthday;
	private Hobby Hobby;

	public Person(int id, String name, String city, Date birthday, Hobby hobby) {
		this(name, city, birthday, hobby);
		this.id = id;
	}

	public Person(String name, String city, Date birthday, Hobby hobby) {
		Name = name;
		this.city = city;
		this.birthday = birthday;
		Hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Hobby getHobby() {
		return Hobby;
	}

	public void setHobby(Hobby hobby) {
		Hobby = hobby;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", Name=" + Name + ", city=" + city + ", birthday=" + birthday + ", Hobby=" + Hobby
				+ "]";
	}

}
