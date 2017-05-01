package com.communityLib.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_request", catalog = "CommunityLibrary")
public class BookRequest implements Serializable {
	private int requestId;
	private Book book;
	private String requestStatus;
	private int requestUser;
	private Date requestDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_id", unique = true, nullable = false)
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "book_id", referencedColumnName = "book_id", foreignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT))
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Column(name = "request_status")
	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	@Column(name = "request_user")
	public int getRequestUser() {
		return requestUser;
	}

	public void setRequestUser(int requestUser) {
		this.requestUser = requestUser;
	}

	@Column(name = "request_dt")
	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

}
