package exceptions;

public class BookAlreadyIssuedException extends Exception{
    
    public BookAlreadyIssuedException(){
        super("Book is already issued") ;
    }

public BookAlreadyIssuedException(String message){
    super(message);
}

}
