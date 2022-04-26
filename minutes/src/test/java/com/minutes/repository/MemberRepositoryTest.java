package com.minutes.repository;

import com.minutes.model.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;


    @Test
    public void insert(){
        Member member = Member.builder()
                .email("hi@gmail.com")
                .name("hi")
                .password("1234")
                .build();

        repository.save(member);
    }

    @Test
    public void insertMany(){
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Member member = Member.builder()
                    .email("user"+i+"@gmail.com")
                    .name("user"+i)
                    .password("1234")
                    .build();
            repository.save(member);
        });

    }
    @Test
    public void read() {
        List<Member> members = repository.findAll();
        Member last = repository.findAll().get(9);
        Assertions.assertEquals(11, members.size());
        Assertions.assertEquals("user10", last.getName());
    }

}