package com.communityLib.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.communityLib.domain.Book;
import com.communityLib.domain.BookRequest;

public interface BookRequestRepository extends CrudRepository<BookRequest, String> {

//	public void save(BookRequest book);	

}
