package com.example.booksAndAuthors1.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "book")
public class Book {
	@Id
    private String id;
	@NotNull(message = "Copies available cannot be blank")
    private int copiesAvailable;

    @NotBlank(message = "Author ID cannot be blank")
    private String authorId;

    @NotBlank(message = "Genre cannot be blank")
    private String genre;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Book(String id, int copiesAvailable, String authorId, String genre) {
		super();
		this.id = id;
		this.copiesAvailable = copiesAvailable;
		this.authorId = authorId;
		this.genre = genre;
	}

    // Constructors, getters, setters
}