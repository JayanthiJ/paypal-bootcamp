package com.communityLib.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book_Author",catalog="CommunityLibrary")
public class BookAuthor implements Serializable {

	private static final long serialVersionUID = 1L;
	private long bookIsbnno;           
	private int	authorSL ;      
	private	String authorName; 
//	private String bookTitle;
	
	public BookAuthor(){
		
	}
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_isbn_no",nullable = false, unique=true)
	public long getBookIsbnno() {
		return bookIsbnno;
	}

	public void setBookIsbnno(long bookIsbnno) {
		this.bookIsbnno = bookIsbnno;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_author_sl",unique = true,nullable=false)
	public int getAuthorSL() {
		return authorSL;
	}


	public void setAuthorSL(int authorSL) {
		this.authorSL = authorSL;
	}
	@Column(name="author_name")
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


}
