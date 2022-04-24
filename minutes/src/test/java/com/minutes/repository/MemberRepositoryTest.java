package com.minutes.repository;

import com.minutes.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
                .role("creator")
                .build();

        repository.save(member);
    }
    @Test
    public void read(){
        List<Member> result = repository.findAll();
        result.forEach(re -> System.out.println(re.getName()));
        System.out.println(result.stream().count());
    }

}