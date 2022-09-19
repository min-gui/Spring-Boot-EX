package com.example.springdb.repository;

import com.example.springdb.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();
    
    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberv3", 10000);
        repository.save(member);
        
        //findById
        Member findMember = repository.findById(member.getMemberId());
        System.out.println("findMember = " + findMember);
        assertThat(findMember).isEqualTo(member);
    }
}