package com.communityLib.service;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communityLib.domain.Book;

@Service
public class BookSearchImpl implements BookSearch {

	@Autowired
	BookSearchRepository bookSearchRepository;
	
	@Override
	public List<Book> findByTitle(String title) {
		System.out.println("inside booksearch impl " + title);
		List<Book> lstBook=	bookSearchRepository.findByBookTitleContaining(title);
		showBooks(lstBook);
		return lstBook;

	}
	@Override
	public Book findByISBN(long isbnNo) {
		System.out.println("inside booksearch impl isbn = "+isbnNo);
	Book book =	bookSearchRepository.findByBookIsbnno(isbnNo);
	System.out.println(book);
		return book;
	}
	

	@Override
	public List<Book> findByAcademicClass(String academicClass) {
		List<Book> lstBook=	bookSearchRepository.findByAcademicClass(academicClass);
		Consumer<Book> bookCons = (book)-> System.out.println(book);
		for (Book book2 : lstBook) {
			bookCons.accept(book2);
		}
			return lstBook;
		}
	

	@Override
	public List<Book> findByGenre(String genre) {
	List<Book> lstBook=	bookSearchRepository.findByGenre(genre);
	showBooks(lstBook);
		return lstBook;
	}

	@Override
	public List<Book> findByAvailabilityStatus() {
		List<Book> lstBook=	bookSearchRepository.findByAvailableStatus(true);
		showBooks(lstBook);
			return lstBook;
	}
	@Override
	public void addBook(Book book) {
		bookSearchRepository.save(book);
		
	}

	
private void showBooks(List<Book> lstBook)
{
	Consumer<Book> bookCons = (book)-> System.out.println(book);
	for (Book book2 : lstBook) {
		bookCons.accept(book2);
	}
}
@Override
public List<Book> findBySearchCriteria(String title, String genre, String author) {
	// TODO Auto-generated method stub
	return null;
}
}
