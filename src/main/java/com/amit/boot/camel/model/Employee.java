package com.amit.boot.camel.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Employee.class)
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int empId;
	private String name;
	private String designation;
	private double salary;
	
	@Override
	public String toString() {
		return "Employee [empName=" + name + ", empId=" + empId + "]";
	}
	
}