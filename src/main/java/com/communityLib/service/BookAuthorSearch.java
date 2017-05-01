package com.communityLib.service;

import java.util.List;

import com.communityLib.domain.Book;
import com.communityLib.domain.BookAuthor;

public interface BookAuthorSearch {
	public List<Book> findByAuthorName(String author);
	public void addBookAuthor(BookAuthor author);
}
