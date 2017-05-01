package com.communityLib.service;

import java.util.List;

import com.communityLib.domain.Book;

public interface BookSearch {
	public List<Book> findByTitle(String title);
	public Book findByISBN(long isbnNo);
	public List<Book> findByAcademicClass(String academicClass);
	public List<Book> findByGenre(String genre);
	public List<Book> findByAvailabilityStatus();
	public void addBook(Book book);
	public List<Book> findBySearchCriteria(String title,String genre,String author);

}
