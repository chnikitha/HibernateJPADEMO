package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subject
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectid;
	private String subjectName1;
	private String subjectName2;
	private String subjectName3;
	private String subjectName4;
	
	public Subject(Long subjectid, String subjectName1, String subjectName2, String subjectName3, String subjectName4) {
		super();
		this.subjectid = subjectid;
		this.subjectName1 = subjectName1;
		this.subjectName2 = subjectName2;
		this.subjectName3 = subjectName3;
		this.subjectName4 = subjectName4;
		
	}
	
	
	public Subject() {
		super();
	}


	@Override
	public String toString() {
		return "Subject [id=" + subjectid + ", subjectName1=" + subjectName1 + ", subjectName2=" + subjectName2
				+ ", subjectName3=" + subjectName3 + ", subjectName4=" + subjectName4 + "]";
	}


	public Long getId() {
		return subjectid;
	}
	public void setId(Long subjectid) {
		this.subjectid = subjectid;
	}
	public String getSubjectName1() {
		return subjectName1;
	}
	public void setSubjectName1(String subjectName1) {
		this.subjectName1 = subjectName1;
	}
	public String getSubjectName2() {
		return subjectName2;
	}
	public void setSubjectName2(String subjectName2) {
		this.subjectName2 = subjectName2;
	}
	public String getSubjectName3() {
		return subjectName3;
	}
	public void setSubjectName3(String subjectName3) {
		this.subjectName3 = subjectName3;
	}
	public String getSubjectName4() {
		return subjectName4;
	}
	public void setSubjectName4(String subjectName4) {
		this.subjectName4 = subjectName4;
	}
	
	
	
	
}
