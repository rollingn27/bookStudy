package com.example.chapter07.persistence;

import com.example.chapter07.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String>
{
}
