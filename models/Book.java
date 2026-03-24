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

    public int getNumberofAvailableCopies(){
        return availableCopies ;
    }

    public int getNumberofTotalCopies(){
        return totalCopies ;
    }

    public void getBookDetails(){
      System.out.println("Book Name: " + bookName);
      System.out.println("Author's name: " + authorName);
      System.out.println("Book ISBN:" + isbn);
      System.out.println("Total book copies: " + totalCopies);
      System.out.println("Total available copies: " + availableCopies);
    }
    

}
