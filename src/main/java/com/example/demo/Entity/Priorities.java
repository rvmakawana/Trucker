package com.example.demo.Entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="priorities")
public class Priorities {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String vin;
	String priority;
	 @Column(columnDefinition = "DATETIME")
	    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss.sTZD")
	    private Date timestamp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	 
	 
	 
}
