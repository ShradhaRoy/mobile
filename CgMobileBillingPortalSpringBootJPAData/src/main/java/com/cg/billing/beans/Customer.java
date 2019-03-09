package com.cg.billing.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int customerID;
	private String firstName, lastName, emailID, dateOfBirth;
	@Embedded
	Address addresses;
	@OneToMany(mappedBy="customer")
	@MapKey
	
	private Map<Long, PostpaidAccount> postpaidAccount = new HashMap<>();
	
	public Customer() {}

	public Customer(String firstName, String lastName, String emailID, String dateOfBirth, Address address,
			Map<Long, PostpaidAccount> postpaidAccount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.dateOfBirth = dateOfBirth;
		this.addresses = address;
		this.postpaidAccount = postpaidAccount;
	}

	public Customer(int customerID, String firstName, String lastName, String emailID, String dateOfBirth,
			Address address, Map<Long, PostpaidAccount> postpaidAccounts) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.dateOfBirth = dateOfBirth;
		this.addresses = address;
		this.postpaidAccount = postpaidAccount;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

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

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return addresses;
	}

	public void setAddress(Address address) {
		this.addresses = address;
	}

	public Map<Long, PostpaidAccount> getPostpaidAccount() {
		return postpaidAccount;
	}

	public void setPostpaidAccounts(Map<Long, PostpaidAccount> postpaidAccount) {
		this.postpaidAccount = postpaidAccount;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailID=" + emailID + ", dateOfBirth=" + dateOfBirth + ", address=" + addresses
				+ ", postpaidAccounts=" + postpaidAccount + "]";
	}
	
	
}