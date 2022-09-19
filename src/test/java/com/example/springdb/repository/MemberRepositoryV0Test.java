package com.example.springdb.repository;

import com.example.springdb.domain.Memeber;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();
    
    @Test
    void crud() throws SQLException {
        Memeber member = new Memeber("memberv1", 10000);
        repository.save(member);
    }
}