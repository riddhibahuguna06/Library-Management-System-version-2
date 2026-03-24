package exceptions ;

public class DuplicateBookException extends Exception{

    public DuplicateBookException(){
        super("Book alreay exists") ;
    }

    public DuplicateBookException(String message){
        super(message);
    }
}