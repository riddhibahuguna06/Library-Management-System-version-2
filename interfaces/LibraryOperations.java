package interfaces;

import models.Book;
import exceptions.BookNotFoundException;
import exceptions.DuplicateBookException;

public interface LibraryOperations{

     void removeBook(String isbn) throws BookNotFoundException;

     Book searchBook(String isbn) throws BookNotFoundException;

     void addBook( Book book) throws DuplicateBookException;

     void displayBooks();

    
}
