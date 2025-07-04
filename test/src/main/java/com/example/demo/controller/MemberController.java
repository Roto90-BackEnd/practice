package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")

//localhost:8080/members/B
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service){
        this.service = service;
    }

    @PostMapping("/create")
    public Member create(@RequestBody Member member){
        return service.save(member);
    }

    @GetMapping("/B")
    public List<Member> getAll(){
        return service.findAll();
    }
}
