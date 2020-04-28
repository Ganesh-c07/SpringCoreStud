package com.cg.iter.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class Student {
	@Id
	private int id;
	private String name;
	private long mobile;
	private String subject;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addr_id")
	private Address address;
	
	public Student(int id, String name, long mobile, String subject, Address address) {
		System.out.println("Stud param 5");
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.subject = subject;
		this.address = address;
	}
	public Student() {
		System.out.println("constr");
	}
	public Student(int id, String name, long mobile, String subject) {
		System.out.println("constr param");
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", subject=" + subject + ", address="
				+ address + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("setting id= "+id);
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Address getAddress() {
		return address;
	}
	//@Autowired
	//@Qualifier(value="addr")
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
