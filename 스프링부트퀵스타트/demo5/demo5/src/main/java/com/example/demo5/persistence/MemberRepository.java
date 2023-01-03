package com.example.demo5.persistence;


import com.example.demo5.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String>
{
}
