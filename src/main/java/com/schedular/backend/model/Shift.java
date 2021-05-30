package com.schedular.backend.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shift")
public class Shift implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "day")
	private String day;
	@Column(name = "date")
	private Date date;
	@Column(name = "session")
	private String session;
	@Column(name = "employeeId")
	private int employeeId;
	@Column(name = "employeeFirstName")
	private String employeeFirstName;
	@Column(name = "employeeLastName")
	private String employeeLastName;
	
	
	
	
	public Shift() {
		
	}
	
	public Shift(String day, Date date, String session, int employeeId, String employeeFirstName, String employeeLastName) {
		this.day = day;
		this.date = date;
		this.session = session;
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	@Override
	public String toString() {
		return "Shift [id=" + id + ", day=" + day + ", date=" + date + ", session=" + session + ", employeeId="
				+ employeeId + ", employeeFirstName=" + employeeFirstName + ", employeeLastName=" + employeeLastName
				+ "]";
	}
	
	
}
