package com.example.booksAndAuthors1.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "author")
public class Author {
    @Id
    private String id;
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotBlank(message = "Name cannot be blank")
    private Address address;
    
//    private List<Book> books;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Author(String id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

    // Constructors, getters, setters
}

class Address {
    private String houseNo;
    private String city;
    public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private String state;
	public Address(String houseNo, String city, String state) {
		super();
		this.houseNo = houseNo;
		this.city = city;
		this.state = state;
	}

    // Constructors, getters, setters
}