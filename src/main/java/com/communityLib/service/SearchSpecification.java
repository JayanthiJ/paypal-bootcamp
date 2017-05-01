package com.communityLib.service;

import org.springframework.data.jpa.domain.Specification;

import com.communityLib.domain.Book;

public class SearchSpecification {
	
	    public static Specification<Book> withTitle(String title) {
	        if (title == null) {
	            return null;
	        } else {
	            // Specification using Java 8 lambdas
	            return (root, query, cb) -> cb.equal(root.get("bookTitle"), title);
	        }
	    }

	    // TODO: Implement withModel, withVehicleType, withBrand, ...
	
}
