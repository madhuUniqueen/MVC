package com.vcube.b32.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class StudentEntity {
    private int id;
    private String firstname;
    private String lastname;
    public StudentEntity() {
	}
	public StudentEntity(String firstname,String lastname) {
		this.firstname=firstname;
		this.lastname=lastname;
	}
	
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY )
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="first_name",nullable=false)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name="last_name",nullable=false)
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String toString() {
		return  id+":"+firstname+":"+lastname;
	}
}
