package com.communityLib.service;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communityLib.domain.Book;
import com.communityLib.domain.BookRequest;

@Service
public class BookRequestServiceImpl implements BookRequestService {

	@Autowired
	BookRequestRepository bookRequestRepository;
	
	@Override
	public void addBookReq(BookRequest bookRequest) {
		bookRequestRepository.save(bookRequest);
	}

	

}
