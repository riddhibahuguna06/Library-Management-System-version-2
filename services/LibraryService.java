package services;
import java.util.ArrayList;
import models.Book;
import exceptions.*;

import interfaces.LibraryOperations;

public class LibraryService implements LibraryOperations {
    private ArrayList<Book> books = new ArrayList<>();
 
    @Override
    public void addBook(Book book) throws DuplicateBookException{
       
        for(Book b: books){
            if(b.getIsbn().equals(book.getIsbn())){
                throw new DuplicateBookException("Book with ISBN " + book.getIsbn() + " already exists");
            }
        }
         books.add(book);
         System.out.println("Book added successfully: " + book.getBookName());
    }

    @Override
    public void removeBook(String isbn) throws  BookNotFoundException{
    
        Book booktoremove = null ;

        for(Book b : books){
            if(b.getIsbn().equals(isbn)){
             booktoremove = b ;
            }
        }

        if(booktoremove == null){
            throw new BookNotFoundException("Book with ISBN: " + isbn + " not found");
        }
        books.remove(booktoremove);
        System.out.println("Book removed sucessfully");
    }

    @Override
    public Book searchBook(String isbn) throws BookNotFoundException{
     
          for(Book b : books){
            if(b.getIsbn().equals(isbn)){
              return b ;
            }
        }
       throw new BookNotFoundException("Book with ISBN: " + isbn + " not found");
    }

    @Override
    public void displayBooks() {
    
        for(Book b : books){
        b.displayBookDetails();
        System.out.println("-----------------");
    
        }
    }
    
}
