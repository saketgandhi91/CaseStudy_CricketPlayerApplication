package com.cg.exception;

public class PlayerAlreadyDeletedException extends Exception 
{
		
	private static final long serialVersionUID = 1L;

	//default constructor
	public PlayerAlreadyDeletedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public PlayerAlreadyDeletedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
