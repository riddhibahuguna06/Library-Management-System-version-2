package exceptions;

public class MaxBookLimitExceedsException extends Exception{
    
    public MaxBookLimitExceedsException(){
        super("Max book limit exceeds");
    }

    public MaxBookLimitExceedsException(String message){
        super(message);
    }
}
