package com.rollingstone.BoardWeb.persistence;

import com.rollingstone.BoardWeb.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String>
{
}
