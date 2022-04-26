package com.minutes.model;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "rooms")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Room {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String subject;
    private String password;
    private String category;

    @CreatedBy
    @DocumentReference
    private Member creator;

    @DocumentReference(lazy = true)
    @Builder.Default
    private Set<Member> participants = new HashSet<>();

    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime finishedTime;

//    @Version
//    private Integer version;

    public void addParticipants(Member member){
        participants.add(member);
    }

    @DocumentReference(lazy = true, lookup="{'roomId': ?#{#self._id} }", sort = "{'createdTime': 1}" )
    private List<Chat> chats;
}
