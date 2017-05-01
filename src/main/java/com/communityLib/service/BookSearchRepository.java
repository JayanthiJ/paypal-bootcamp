package com.communityLib.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.communityLib.domain.Book;

public interface BookSearchRepository extends CrudRepository<Book, String> {
	public Book findByBookTitleAndPublisher(String title,String publisher);
	public List<Book> findByBookTitleContaining(String title) ;
	public List<Book> findByGenre(String genre);	
	public List<Book> findByAcademicClass(String academicClass) ;
	public Book findByBookIsbnno(long isbnNo); 
	public List<Book> findByAvailableStatus(boolean status);
}
