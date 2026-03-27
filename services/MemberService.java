package services;

import models.Member;

import exceptions.MemberNotFoundException;
import exceptions.DuplicateMemberException;

import java.util.ArrayList;

import interfaces.MemberOperations;

public class MemberService implements MemberOperations {
    
   private ArrayList<Member>members = new ArrayList<>();

    @Override
    public void registerMember(Member member) throws DuplicateMemberException{
    
        for(Member m : members){
            if(m.getMemberId().equals(member.getMemberId())){
                throw new  DuplicateMemberException("Member with " + member.getMemberId() + " member id already exists");
            }
        }
        members.add(member);
        System.out.println("New member is sucessfully registered");

    }

     @Override
    public void removeMember(String memberId) throws MemberNotFoundException{

       Member membertoremove = null ;
        for(Member m : members){
            if(m.getMemberId().equals(memberId)){
            membertoremove = m ;
            }
        } 
        if(membertoremove == null){
                throw new MemberNotFoundException("Member with " + memberId + " member id not found");
            }
            members.remove(membertoremove);
            System.out.println("Member sucessfully removed");
        
    }

    @Override
    public Member searchMember(String memberId) throws MemberNotFoundException{

        for(Member m : members){
            if(m.getMemberId().equals(memberId)){
                return m;
            }
        }
        throw new MemberNotFoundException("Member with " + memberId + " member id not found");
    }
    
    @Override
    public void displayMember(){
        for(Member m : members){
          m.displayMemberDetails();

          System.out.println("----------------");
        }
    }
}
