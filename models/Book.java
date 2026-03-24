package models;

public class Book {
    
    private String bookName ;
    private String authorName;
    private String isbn ;
    private int availableCopies;
    private int totalCopies;

    public Book(String bookName , String authorName , String isbn , int availableCopies , int totalCopies){
    
        this.bookName = bookName ;
        this.authorName = authorName;
        this.totalCopies = totalCopies ;
        this.availableCopies = availableCopies ;
        this.isbn = isbn ;
    }

    public String getBookName(){
        return bookName ;
    }

    public String getAuthorName(){
        return authorName ;
    }

    public String getIsbn(){
        return isbn;
    }

}
