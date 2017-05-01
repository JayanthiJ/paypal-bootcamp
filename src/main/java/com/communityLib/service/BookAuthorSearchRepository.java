package com.communityLib.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.communityLib.domain.Book;
import com.communityLib.domain.BookAuthor;

public interface BookAuthorSearchRepository extends CrudRepository<BookAuthor,String> {
//	@SuppressWarnings("rawtypes")
	public List<BookAuthor> findByAuthorNameContaining(String author) ;
}
