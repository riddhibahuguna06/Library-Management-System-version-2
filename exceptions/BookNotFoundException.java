 package exceptions;

    public class BookNotFoundException extends Exception{
    
        public BookNotFoundException(){
            super("Book not found in the system");
        }

        public BookNotFoundException(String message){  // constructor for exceptions
            super(message) ;
        }
    }
