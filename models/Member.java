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
    
}
