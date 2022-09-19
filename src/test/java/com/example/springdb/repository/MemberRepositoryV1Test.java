 package com.example.springdb.repository;

 import com.example.springdb.domain.Member;
 import com.zaxxer.hikari.HikariDataSource;
 import lombok.extern.slf4j.Slf4j;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;

 import java.sql.SQLException;
 import java.util.NoSuchElementException;

 import static com.example.springdb.connection.ConnectionConst.*;
 import static org.assertj.core.api.Assertions.assertThat;
 import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;

    @BeforeEach
    void beforeEach(){
        //기본 driverManager - 항상 새로운 커넥션을 획득
        //DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);

        //커넥션 풀링
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPoolName(PASSWORD);


        repository = new MemberRepositoryV1(dataSource);
    }
    
    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("member10", 10000);
        repository.save(member);
        
        //findById
        Member findMember = repository.findById(member.getMemberId());
        System.out.println("findMember = " + findMember);
        assertThat(findMember).isEqualTo(member);

        //update: money : 10,000 -> 20,000
        repository.update(member.getMemberId(), 20000);
        Member updateMember = repository.findById(member.getMemberId());
        assertThat(updateMember.getMoney()).isEqualTo(20000);

        //delete
        repository.delete(member.getMemberId());
        assertThatThrownBy(() -> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}