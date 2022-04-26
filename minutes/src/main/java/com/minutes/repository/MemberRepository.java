package com.minutes.repository;

import com.minutes.model.Member;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MemberRepository extends MongoRepository<Member, ObjectId> {
    @Query("{name: '?0'}")
    Member findMemberByName(String name);

}
