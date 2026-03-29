package services;

import models.*;
import exceptions.*;
import  interfaces.IssueOperations;

public class IssueService implements IssueOperations {
    private LibraryService libraryService;
private MemberService memberService;

public IssueService(LibraryService libraryService, MemberService memberService) {
    this.libraryService = libraryService;
    this.memberService = memberService;

}

 @Override
    public void issueBook(String memberId, String isbn) throws MemberNotFoundException, BookNotFoundException, BookNotAvailableException, MaxBookLimitExceedsException, BookAlreadyIssuedException {
        
        Member member = memberService.searchMember(memberId);
         Book book = libraryService.searchBook(isbn);
      
        if(book.getAvailableCopies() <= 0){
        throw new BookNotAvailableException();
       }

       if(member.getIssuedBook().size() >= member.getMaxBookLimit()){
        throw new MaxBookLimitExceedsException();
       }

       for(Book b : member.getIssuedBook()){
        if(b.getIsbn().equals(isbn)){
            throw new BookAlreadyIssuedException();
        }

       }
       member.addIssuedBook(book);
       book.setAvailableCopies(book.getAvailableCopies() - 1);
       System.out.println("Book issued sucessfully to : " + member.getName());
 
    }

    @Override
    public void returnBook(String isbn, String memberId) throws  MemberNotFoundException , BookNotFoundException {
        Member member = memberService.searchMember(memberId);
        Book book = libraryService.searchBook(isbn);

        Book booktoReturn = null ;

        for(Book b : member.getIssuedBook()){
            if(b.getIsbn().equals(isbn)){
                booktoReturn = b ;
            }
        }

        if(booktoReturn == null){
            throw new BookNotFoundException("This member does not have this book issued");
        }

        member.removeIssuedBook(booktoReturn);
        book.setAvailableCopies(book.getAvailableCopies() + 1 );
        System.out.println("Book returned successfully by " + member.getName());

    }

   
}


