package com.example.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

// 현재 코드의 문제점 1.
// Entity의 무분별한 Setter: @Setter는 객체의 일관성을 해칠 수 있어 Entity에서는 사용을 지양하는 것이 좋습니다.
@Entity
@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
}
