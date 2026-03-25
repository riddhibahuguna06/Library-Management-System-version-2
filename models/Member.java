package models;

import java.util.ArrayList ;

public class Member {
    private String name;
    private String memberId ;
    private String mobileNumber;
    private String memberType;  //student , teacher or guest
    private int maxBookLimit;
    private ArrayList <Book> issuedBooks;

    public Member(String name, String memberId , String mobileNumber , String memberType , int maxBookLimit ){

        this.name = name ;
        this.memberId = memberId ;
        this.maxBookLimit = maxBookLimit ;
        this.memberType = memberType ;
        this.mobileNumber = mobileNumber;
        this.issuedBooks = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getMemberId(){
        return memberId;
    }

    public String getMobileNum(){
        return mobileNumber;
    }

    public int getMaxBookLimit(){
        return maxBookLimit ;
    }
    
    public String getMemberType(){
        return memberType;
    }

    public ArrayList<Book> getIssuedBook(){
        return issuedBooks ;
    }

    public void addIssuedBook(Book book){
    issuedBooks.add(book);
    }
    
    public void removeIssuedBook(Book book){
        issuedBooks.remove(book);
    }

    public void displayMemberDetails(){
    System.out.println("Member ID: " + memberId);
    System.out.println("Name: " + name);
    System.out.println("Mobile: " + mobileNumber);
    System.out.println("Member Type: " + memberType);
    System.out.println("Max Book Limit: " + maxBookLimit);
    System.out.println("Books Issued: " + issuedBooks.size());
}
}
