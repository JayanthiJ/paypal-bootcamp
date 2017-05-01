package com.communityLib.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.communityLib.domain.Book;
import com.communityLib.domain.BookRequest;
import com.communityLib.domain.User;
import com.communityLib.service.BookAuthorSearch;
import com.communityLib.service.BookRequestService;
import com.communityLib.service.BookSearch;
import com.communityLib.service.LoginService;

@Controller
public class CommLibController {
	// @Value("${welcome.message:test}")
	// private String message = "Hello World";
	@Autowired
	LoginService loginService;
	@Autowired
	BookSearch bookSearch;
	@Autowired
	BookAuthorSearch bookAuthorSearch;
	@Autowired
	BookRequestService bookRequestSearch;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		// User user = userService.getUser(2);
		// model.put("message", this.message);
		// model.put("use", user);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String uname, @RequestParam("password") String pwd,
			Map<String, Object> model) {
		List<User> users = loginService.findByUserName(uname);
		String page = "welcome";
		for (User user : users) {
			// user.getPassword();
			// loginService.validate(user, pwd);
			System.out.println("user  " + uname);
			if (loginService.validate(user, pwd)) {
				System.out.println("inside if ");
				String type = user.getUserType();
				if (type.equalsIgnoreCase("R"))
					page = "bookRequestor";
				else if (type.equalsIgnoreCase("D"))
					page = "donor";
				else
					page = "admin";

			}
			model.put("firstLoad", "first");
		}
		return page;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchBooks(@RequestParam("bookTitle") String bookTitle, @RequestParam("genre") String genre,
			@RequestParam("bookIsbnno") String bookIsbnno, @RequestParam("authorName") String authorName,
			@RequestParam("availableStatus") String availableStatus, Map<String, Object> model) {
		String page = "bookRequestor";
		Book searchBook = new Book();
		List<Book> lstBook = new ArrayList<Book>();
		System.out.println("Title from request  " + bookTitle);
		int queryTitle=0;
		int queryIsbn=0;
		if (bookTitle != null && !(bookTitle.trim().isEmpty())) {
			queryTitle = 1;
			lstBook = bookSearch.findByTitle(bookTitle);
			model.put("book", lstBook);
		} else if (null != bookIsbnno && (bookIsbnno.trim().length() > 1)) {
			queryIsbn=1;
			System.out.println("bookIsbnno from request  " + bookIsbnno);
			bookIsbnno = bookIsbnno.substring(0, bookIsbnno.length() - 2);
			System.out.println("bookIsbnno from request  " + bookIsbnno);
			searchBook = bookSearch.findByISBN(Long.parseLong(bookIsbnno));
			lstBook.add(searchBook);
			model.put("book", lstBook);
		} else if (null != genre && !(genre.trim().isEmpty())) {
			// genre =genre.substring(0,genre.length()-2);
			System.out.println("genre from request  " + genre);
			lstBook = bookSearch.findByGenre(genre);
			model.put("book", lstBook);
		} else if (null != authorName && !(authorName.trim().isEmpty())) {
			// genre =genre.substring(0,genre.length()-2);
			System.out.println("genre from request  " + authorName);
			lstBook = bookAuthorSearch.findByAuthorName(authorName);
			model.put("book", lstBook);
		} else if (null != availableStatus && !(availableStatus.trim().isEmpty())) {
			// genre =genre.substring(0,genre.length()-2);
			System.out.println("availableStatus from request  " + availableStatus);
			lstBook = bookSearch.findByAvailabilityStatus();
			model.put("book", lstBook);
		} //

		page = "bookRequestor";
		return page;
	}

	@RequestMapping(value = "/requestBook", method = RequestMethod.GET)
	public String requestBook(@RequestParam("bookIsbnno") String bookIsbnno, Map<String, Object> model) {
		System.out.println("inside request book " + bookIsbnno);
		Book searchBook = bookSearch.findByISBN(Long.parseLong(bookIsbnno));
		BookRequest bookReq = new BookRequest();
		bookReq.setBook(searchBook);
		bookReq.setRequestDate(new Date());
		bookReq.setRequestStatus("p");
		bookRequestSearch.addBookReq(bookReq);
		model.put("reqMsg", "success");
		String page = "bookRequestor";
		model.put("firstLoad", "first");
		return page;
	}

}
