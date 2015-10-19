package fr.esiea.main.domain.users;

public class ExistingUserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExistingUserException() { super(); }
	public ExistingUserException(String message) { super(message); }
	public ExistingUserException(String message, Throwable cause) { super(message, cause); }
	public ExistingUserException(Throwable cause) { super(cause); }
}
