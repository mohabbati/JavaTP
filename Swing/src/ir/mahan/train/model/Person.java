package ir.mahan.train.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5623347336058536359L;
	
	public static int count = 0;
	public int ID;
	public String firstName;
	public String lastName;
	public Gender gender;
	public int age;
	public Category category;
	public List<City> city;
	public List<Sport> sport;
	public boolean isEmployee;
	public long salary;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<City> getCity() {
		return city;
	}
	public void setCity(List<City> city) {
		this.city = city;
	}
	public List<Sport> getSport() {
		return sport;
	}
	public void setSport(List<Sport> sport) {
		this.sport = sport;
	}
	public boolean isEmployee() {
		return isEmployee;
	}
	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public Person() {
		
		super();
		
		this.ID = count++;
		
		this.city = new ArrayList<>();
		this.sport = new ArrayList<>();
	}
	
}
