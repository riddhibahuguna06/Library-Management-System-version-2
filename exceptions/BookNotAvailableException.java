package exceptions;

public class BookNotAvailableException extends Exception{

    public BookNotAvailableException(){
        super("Book is not available");
    }

    public BookNotAvailableException( String message){
        super(message);
    }
}