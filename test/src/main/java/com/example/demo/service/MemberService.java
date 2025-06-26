package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repo;

    public MemberService(MemberRepository repo){
        this.repo = repo;
    }

    public Member save(Member member){
        return repo.save(member);
    }

    public List<Member> findAll(){
        return repo.findAll();
    }


}
