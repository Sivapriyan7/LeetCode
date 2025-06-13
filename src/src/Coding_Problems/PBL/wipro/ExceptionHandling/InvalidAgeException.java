package src.Coding_Problems.PBL.wipro.ExceptionHandling;

public class InvalidAgeException extends Exception {
    // Constructor with a message
    public InvalidAgeException(String message) {
        super(message);
    }

    // Default constructor
    public InvalidAgeException() {
        super();
    }
}

