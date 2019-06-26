package io.seyon.company.config;

public class CompanyAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3807491481293428935L;

	public CompanyAlreadyExistException(){
		super();
	}
	
	public CompanyAlreadyExistException(String message){
		super(message);
	}
}
