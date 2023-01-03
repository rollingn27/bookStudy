package com.example.chapter07.config;

import com.example.chapter07.domain.Member;
import com.example.chapter07.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardUserDetailsService implements UserDetailsService
{
    private final MemberRepository memberRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optional = memberRepo.findById(username);
        if(!optional.isPresent())
            throw new UsernameNotFoundException(username + " 사용자 없음");
        else {
            Member member = optional.get();
            return new SecurityUser(member);
        }
    }
}
