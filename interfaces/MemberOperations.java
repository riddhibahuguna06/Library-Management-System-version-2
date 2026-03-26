package interfaces ;

import models.Member ;
import exceptions.MemberNotFoundException;
import exceptions.DuplicateMemberException;

public interface MemberOperations{

    void registerMember(Member member) throws DuplicateMemberException;

    void removeMember(String memberId) throws MemberNotFoundException ;

    Member searchMember(String MemberId) throws MemberNotFoundException;

    void displayMember();
}