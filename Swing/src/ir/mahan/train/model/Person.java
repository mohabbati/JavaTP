package ir.mahan.train.model;

import java.util.List;

public class Person {
	
	public String firstName;
	public String lastName;
	public Gender gender;
	public int age;
	public Category category;
	public City city;
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
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
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
	
	
	public Person(String firstName, String lastName, Gender gender, int age,
			Category category, City city, List<Sport> sport,
			boolean isEmployee, long salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.category = category;
		this.city = city;
		this.sport = sport;
		this.isEmployee = isEmployee;
		this.salary = salary;
	}

}
