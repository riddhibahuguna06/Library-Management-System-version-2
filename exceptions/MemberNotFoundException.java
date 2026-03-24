package exceptions;

public class MemberNotFoundException extends Exception{

    //default message constructor
    public MemberNotFoundException(){
    super("Member not found in the system");
    }

   //custome message constructor
  public MemberNotFoundException(String message){
    super(message);
  }
}