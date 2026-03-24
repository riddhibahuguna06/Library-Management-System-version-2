package exceptions;

public class DuplicateMemberException extends Exception{

    public DuplicateMemberException(){
        super("Member already exists");
    }

    public DuplicateMemberException(String message){
        super(message);
    }
}