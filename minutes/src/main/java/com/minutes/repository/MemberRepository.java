package com.minutes.repository;

import com.minutes.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MemberRepository extends MongoRepository<Member, String> {
}
