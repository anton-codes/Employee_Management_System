package company;

/**
 * This class is responsible for indicating logic related errors
 * <p>
 * Course Name: CST8284 Object Oriented Programming (Computer Programmer).
 * Student name: Anton Hrytsyk.
 * Student number: 040938383
 *
 * Professor Jason M
 * Assignment title: Company Management Tool Prototype.
 * Assignment due date: Sunday April 14, 2019 by 11:59.
 *
 *
 *
 * @version Assignment 3
 * ConsoleException exception class.
 *
 * 
 * @author Anton Hrytsyk
 * </p>
 *
 */
public class ConsoleException extends RuntimeException {
	
	/** Used during deserialization to confirm that objects are compatible. 
	 * @value 1L
	 */
    private static final long serialVersionUID = 1L;

    /**
     * ConsoleException constructor.
     *
     * Passes message to the superclass.
     * @param message message indicating the exception.
     */
    public ConsoleException(String message) {
        super(message);

    }

    /**
     * Default ConsoleException constructor
     *
     * Chained to <code> this(message) </code> constructor
     * Passes default error massage to the superclass,
     * and prints the stacktrace.
     */
    public ConsoleException() {
        this("There appears to be a problem with the execution of this code.");
        super.printStackTrace();
    }


}

