package com.communityLib.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "book", catalog = "CommunityLibrary")
public class Book {
	private long bookId;
	private long bookIsbnno;
	private String bookTitle;
	private String academicClass;
	private String genre;
	private String publisher;
	private String publishYear;
	private int donatedUser; // foreign key
	private Date donatedDt;
	private boolean availableStatus;
	private long issuedRequestId; // foreign key
	private int receivingUserId; // foreign key
	private Date receivedUserDt;

	private int version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", unique = true, nullable = false)
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	@Column(name = "book_title")
	public String getBookTitle() {
		return bookTitle;
	}

	@Column(name = "book_isbn_no")
	public long getBookIsbnno() {
		return bookIsbnno;
	}

	public void setBookIsbnno(long bookIsbnno) {
		this.bookIsbnno = bookIsbnno;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	@Column(name = "academic_class")
	public String getAcademicClass() {
		return academicClass;
	}

	public void setAcademicClass(String academicClass) {
		this.academicClass = academicClass;
	}

	@Column(name = "genre")
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Column(name = "publisher")
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name = "publish_year")
	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	@Column(name = "donated_user")
	public int getDonatedUser() {
		return donatedUser;
	}

	public void setDonatedUser(int donatedUser) {
		this.donatedUser = donatedUser;
	}

	@Column(name = "donated_dt")
	public Date getDonatedDt() {
		return donatedDt;
	}

	public void setDonatedDt(Date donatedOn) {
		this.donatedDt = donatedOn;
	}

	@Column(name = "available_status")
	public boolean isAvailableStatus() {
		return availableStatus;
	}

	public void setAvailableStatus(boolean availableStatus) {
		this.availableStatus = availableStatus;
	}

	@Column(name = "issued_request_id")
	public long getIssuedRequestId() {
		return issuedRequestId;
	}

	public void setIssuedRequestId(long issuedRequestId) {
		this.issuedRequestId = issuedRequestId;
	}

	@Column(name = "receiving_user_id")
	public int getReceivingUserId() {
		return receivingUserId;
	}

	public void setReceivingUserId(int receivingUser) {
		this.receivingUserId = receivingUser;
	}

	@Column(name = "received_user_dt")
	public Date getReceivedUserDt() {
		return receivedUserDt;
	}

	public void setReceivedUserDt(Date receivedUserDt) {
		this.receivedUserDt = receivedUserDt;
	}

	public String toString() {
		StringBuilder strBook = new StringBuilder(" Title:  ");
		strBook.append(bookTitle).append(" AcademicClass :  ").append(academicClass).append(" Publisher: ")
				.append(this.publisher);
		return strBook.toString();
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
