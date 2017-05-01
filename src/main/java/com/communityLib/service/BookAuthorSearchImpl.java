package com.communityLib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communityLib.domain.Book;
import com.communityLib.domain.BookAuthor;

@Service
public class BookAuthorSearchImpl implements BookAuthorSearch{
	@Autowired
	BookAuthorSearchRepository bookAuthorSearchRepository;
	@Autowired
	BookSearchRepository bookSearchRepositor;

	@Override
	public List<Book> findByAuthorName(String author){
		List<Book> BookListByAuthor=new ArrayList<Book>();
		Book tempBook=new Book();
		List<BookAuthor> lstIsbn =  bookAuthorSearchRepository.findByAuthorNameContaining(author);
		
	for (BookAuthor bookAuthor : lstIsbn) {
		System.out.println("selected isbn :   "+bookAuthor.getBookIsbnno());
			tempBook= bookSearchRepositor.findByBookIsbnno(bookAuthor.getBookIsbnno());
			System.out.println(tempBook.getBookTitle());
			BookListByAuthor.add(tempBook);
		}
			Consumer<Book> bookCons = (book)-> System.out.println(book);
			for (Book book2 : BookListByAuthor) {
				bookCons.accept(book2);
			}
			return BookListByAuthor;
		
	}
	@Override
	public void addBookAuthor(BookAuthor author) {
		bookAuthorSearchRepository.save(author);

	}



}
