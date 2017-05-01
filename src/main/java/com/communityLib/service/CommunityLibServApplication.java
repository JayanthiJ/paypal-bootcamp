package com.communityLib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import com.communityLib.domain.Book;
import com.communityLib.domain.BookAuthor;
import com.communityLib.domain.BookRequest;
import com.communityLib.domain.User;

@SpringBootApplication(scanBasePackages={"com.communityLib.*"})
@EntityScan(basePackageClasses={Book.class,BookAuthor.class,User.class,BookRequest.class})
public class CommunityLibServApplication implements CommandLineRunner {
	
	@Autowired
	ApplicationContext myApplnContext;
	public static void main(String[] args) {
		SpringApplication.run(CommunityLibServApplication.class,args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		BookAuthorSearch bookAuthSearchService =myApplnContext.getBean(BookAuthorSearch.class);
//		BookSearchFunctionality();
//	BookAuthor author = new BookAuthor();
//	author.setAuthorName("kathy");
//	author.setBookIsbnno(553456789012L);
//	bookAuthSearchService.addBookAuthor(author);
//	BookAuthor author1 = new BookAuthor();
//	author1.setAuthorName("kathy");
//	author1.setBookIsbnno(7632879054L);
//	bookAuthSearchService.addBookAuthor(author1);
//	bookAuthSearchService.findByAuthorName("kathy");
	}
	
	private void createBooks(BookSearch bookSearchService){
		Book book1 = new Book();
		book1.setAcademicClass("NA");
		book1.setAvailableStatus(false);
		book1.setBookIsbnno(123456789012L);
		book1.setBookTitle("java8 in Action");
		book1.setGenre("tech");
		book1.setPublisher("Mario Fusco");
		book1.setDonatedUser(1);
		book1.setPublishYear("2014");
		bookSearchService.addBook(book1);
		Book book11 = new Book();
		book11.setAcademicClass("NA");
		book11.setAvailableStatus(true);
		book11.setBookIsbnno(553456789012L);
		book11.setBookTitle("java 8 in complete");
		book11.setGenre("tech");
		book11.setPublisher("kathy sierra");
		book11.setDonatedUser(1);
		book11.setPublishYear("2014");
		bookSearchService.addBook(book11);
		Book book12 = new Book();
		book12.setAcademicClass("NA");
		book12.setAvailableStatus(true);
		book12.setBookIsbnno(7632879054L);
		book12.setBookTitle("java persistance");
		book12.setGenre("tech");
		book12.setPublisher("kathy sierra");
		book12.setDonatedUser(1);
		book12.setPublishYear("2014");
		bookSearchService.addBook(book12);
	}
	private void BookSearchFunctionality(){
		BookSearch bookSearchService =myApplnContext.getBean(BookSearch.class);
//		bookSearchService.findByTitle("java8");
		
		/*BookAuthorSearch bookAuthSearchService =myApplnContext.getBean(BookAuthorSearch.class);
		bookAuthSearchService.findByAuthorName("kathy");*/
		
		createBooks(bookSearchService);
//		bookSearchService.findByGenre("tech");
//		System.out.println("One more search");
//		bookSearchService.findByAcademicClass("NA");
		bookSearchService.findByAvailabilityStatus();
		bookSearchService.findByTitle("java 8 in complete");
	}

}
