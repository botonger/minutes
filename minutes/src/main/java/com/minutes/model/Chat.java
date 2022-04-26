package com.minutes.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Document(collection = "chats")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chat {
    @Id
    private ObjectId id;
    @CreatedDate
    private LocalDateTime createdTime;
    private String message;

    @DocumentReference
    private Member member;
    @DocumentReference
    private Room room;
}
