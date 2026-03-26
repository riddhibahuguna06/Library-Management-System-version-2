package interfaces;

import  exceptions.BookAlreadyIssuedException;
import exceptions.MaxBookLimitExceedsException;
import exceptions.MemberNotFoundException;
import exceptions.BookNotAvailableException;
import exceptions.BookNotFoundException;

public interface  IssueOperations {
    
    public void issueBook(String memberId , String isbn) throws MemberNotFoundException , BookAlreadyIssuedException , BookNotAvailableException , BookNotFoundException , MaxBookLimitExceedsException ;

    public void returnBook(String isbn , String memberId) throws MemberNotFoundException , BookNotFoundException ;
}