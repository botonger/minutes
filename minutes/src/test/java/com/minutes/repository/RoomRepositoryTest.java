package com.minutes.repository;

import com.minutes.model.Member;
import com.minutes.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RoomRepositoryTest {
    @Autowired
    RoomRepository repository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void insert(){
        Member member = memberRepository.findMemberByName("hi");
        Room room = Room.builder().category("fun")
                .subject("testSub")
                .password("1234")
                .creator(member)
                .build();
        room.addParticipants(member);

        repository.save(room);
    }
    @Test
    public void addMember(){
        Member member = memberRepository.findMemberByName("user1");
        Room room = repository.findById("626800fc6c2f7d40714ff880").get();
        room.addParticipants(member);

        repository.save(room);
    }
}