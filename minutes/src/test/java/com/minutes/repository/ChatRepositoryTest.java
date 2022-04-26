package com.minutes.repository;

import com.minutes.model.Chat;
import com.minutes.model.Member;
import com.minutes.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatRepositoryTest {
    @Autowired
    ChatRepository repository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RoomRepository roomRepository;

    @Test
    public void insert(){
        Member member = memberRepository.findMemberByName("hi");
        Room room = roomRepository.findById("626800fc6c2f7d40714ff880").get();
        Chat chat = Chat.builder()
                .message("hi, i am hi")
                .member(member)
                .room(room)
                .build();
        Chat saved = repository.save(chat);

        assertEquals("hi, i am hi", saved.getMessage());



    }
}