package com.pratap.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.pratap.hibernate.constants.AddressType;

/**
 * 
 * @author Pratap Narayan
 * Embedded Value Type : A composition of values, promotes reuse across other entities
 *
 */
@Embeddable
public class Address {

	// since this is a value type, hence there is no identifier ie primary key
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "address_type")
	private AddressType addressType;
	
	public Address() {}
	
	public Address(String street, String city, String zipcode, AddressType addressType) {
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.addressType = addressType;
	}



	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

}
