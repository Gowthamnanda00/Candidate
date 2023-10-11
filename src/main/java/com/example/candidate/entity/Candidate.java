package com.example.candidate.entity;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Candidate {
	@Id
	private int id;
	private String name;
	private int roll;
	private int salary;
	private String place;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Candidate(int id, String name, int roll, int salary, String place) {
		super();
		this.id = id;
		this.name = name;
		this.roll = roll;
		this.salary = salary;
		this.place = place;
	}
	public Candidate()
	{
		
	}
	
	

}
