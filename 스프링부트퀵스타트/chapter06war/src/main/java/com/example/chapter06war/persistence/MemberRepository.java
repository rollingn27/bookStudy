package com.example.chapter06war.persistence;

import com.example.chapter06war.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String>
{
}
