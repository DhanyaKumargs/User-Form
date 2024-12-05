package com.example.UserDemo.domain;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
	
	@Id
	private String id;
	@Nonnull
	private String userName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String description;
	
	private LocalDate experienceDate;
	private String dateFormte;
	private double timeOut;
	private List<String> roleName;
	private String scopeName;
	 private ZoneId timeZone;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getExperienceDate() {
		return experienceDate;
	}
	public void setExperienceDate(LocalDate experienceDate) {
		this.experienceDate = experienceDate;
	}
	
	public String getDateFormte() {
		return dateFormte;
	}
	public void setDateFormte(String dateFormte) {
		this.dateFormte = dateFormte;
	}
	public double getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(double timeOut) {
		this.timeOut = timeOut;
	}
	public List<String> getRoleName() {
		return roleName;
	}
	public void setRoleName(List<String> roleName) {
		this.roleName = roleName;
	}
	public String getScopeName() {
		return scopeName;
	}
	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}
	public ZoneId getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(ZoneId timeZone) {
		this.timeZone = timeZone;
	}
	
	
	
}
