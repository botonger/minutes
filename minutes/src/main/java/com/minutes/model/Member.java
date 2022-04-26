package com.minutes.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Encrypted(keyId = "chocolate", algorithm = "AEAD_AES_256_CBC_HMAC_SHA_512-Random")
@Document(collection = "members")
public class Member {
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String email;

    private String name;

    @Encrypted
    private String password;
}
