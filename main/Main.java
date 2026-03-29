package main;

import java.util.Scanner;
import models.Book;
import models.Member;
import services.LibraryService;
import services.MemberService;
import services.IssueService;
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        
    LibraryService libraryService = new LibraryService();
    MemberService memberService = new MemberService();
    IssueService issueService = new IssueService(libraryService, memberService);
    Scanner sc = new Scanner(System.in);

   String bookName ;
   String authorName;
   String isbn;
   int totalCopies;
   String memberId;
  
    while(true){
     System.out.println("----------Library Management System----------");
     System.out.println("\n===== Library Management System =====");
    System.out.println("1. Add Book");
    System.out.println("2. Remove Book");
    System.out.println("3. Search Book");
    System.out.println("4. Register Member");
    System.out.println("5. Issue Book");
    System.out.println("6. Return Book");
    System.out.println("7. Exit");
    System.out.print("Enter your choice: ");

   int choose = sc.nextInt();
    sc.nextLine();

    switch (choose) {
        case 1: // addBook
       
        System.out.println("Name of the Book: ");
        bookName = sc.nextLine();

        System.out.println("Name of the Author: ");
        authorName = sc.next();
        sc.nextLine();

        System.out.println(" Book ISBN number: ");
        isbn = sc.next();
        sc.nextLine();

        System.out.println("Enter total copies: ");
        totalCopies = sc.nextInt();

         Book book = new Book(bookName, authorName, isbn, totalCopies, totalCopies);

         try{
           libraryService.addBook(book);
         }catch(DuplicateBookException e){
           System.out.println("Error: " + e.getMessage());
         }
       
            break;

        case 2: //removeBook

        System.out.println(" Book ISBN number: ");
        isbn = sc.next();
        sc.nextLine();

         try{
            libraryService.removeBook(isbn);
         }catch(BookNotFoundException e){
            System.out.println("Error: " + e.getMessage());
         }
            
            break;

        case 3: // search book

         System.out.println(" Book ISBN number: ");
         isbn = sc.next();
         sc.nextLine();

         try{
          Book foundBook =  libraryService.searchBook(isbn);
          foundBook.displayBookDetails();
         }catch(BookNotFoundException e){
            System.out.println("Error: " + e.getMessage());
         }
 
            break;

        case 4: // register member

        System.out.println("Your Name: ");
        String name = sc.next();
        sc.nextLine();

        System.out.println("Your Mobile Number: ");
        String mobileNumber = sc.next();
        sc.nextLine();

        System.out.println("Member type : ");
        String memberType = sc.next();
        sc.nextLine();

        System.out.println("Max book limit: ");
        int maxBookLimit = sc.nextInt();

       String generatedId = memberService.generateMemberId();
       System.out.println("Your new Member ID: " + generatedId);
       Member member = new Member(name, generatedId, mobileNumber, memberType, maxBookLimit);

        try{
            memberService.registerMember(member);
        }catch( DuplicateMemberException e){
            System.out.println("Error: " + e.getMessage());
        }
  
            break;

        case 5: //issueBook

        System.out.println("Your Member ID : ");
         memberId = sc.next();
        sc.nextLine();

        System.out.println("Book ISBN number: ");
        isbn = sc.next();
        sc.nextLine();

        try{
            issueService.issueBook(memberId, isbn);
        }catch(BookNotFoundException e){
         System.out.println("Error: " + e.getMessage());
        }catch(MemberNotFoundException e ){
            System.out.println("Error: " + e.getMessage());
        }catch(BookNotAvailableException e){
            System.out.println("Error: " + e.getMessage());
        }catch(MaxBookLimitExceedsException e){
            System.out.println("Error: " + e.getMessage());
        }catch(BookAlreadyIssuedException e ){
           System.out.println("Error: " + e.getMessage());
        } 
            
            break;

        case 6: // return book
         
        System.out.println("Your Member ID : ");
        memberId = sc.next();
        sc.nextLine();

        System.out.println("Book ISBN number: ");
        isbn = sc.next();
        sc.nextLine();

        try{
            issueService.returnBook(isbn, memberId);
        }catch(MemberNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }catch(BookNotFoundException e){
           System.out.println("Error: " + e.getMessage());
        }

            break;
    
        case 7://exit
            System.out.println("Goodbye");
            sc.close();
            return;
    
        default:
            break;
    }



    }
}
    }

