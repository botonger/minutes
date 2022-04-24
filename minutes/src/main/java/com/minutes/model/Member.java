package com.minutes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Document(collection = "members")
public class Member {
    @Id
    private String email;

    private String name;
    private String password;
    private String role;

}
