package com.cg.helix.persistence.exception;

public class NoResultsException extends Exception {
	String message = "";

	public NoResultsException(String message) {
		this.message = message;
	}

}
