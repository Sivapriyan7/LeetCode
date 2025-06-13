package src.Coding_Problems.PBL.wipro.ExceptionHandling;

public class InvalidCountryException extends Exception {
    // Constructor with a message
    public InvalidCountryException(String message) {
        super(message);
    }

    // Default constructor
    public InvalidCountryException() {
        super();
    }
}
