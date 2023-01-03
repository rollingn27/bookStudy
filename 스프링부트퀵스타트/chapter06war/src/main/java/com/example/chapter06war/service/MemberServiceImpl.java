package com.example.chapter06war.service;


import com.example.chapter06war.domain.Member;
import com.example.chapter06war.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService
{
    private final MemberRepository memberRepo;

    @Override
    public Member getMember(Member member)
    {
        Optional<Member> findMember = memberRepo.findById(member.getId());
        if(findMember.isPresent())
            return findMember.get();
        else
            return null;
    }
}
