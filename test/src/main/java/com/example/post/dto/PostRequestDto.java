package com.example.post.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PostRequestDto {
    // **@NotBlank**는 이름 그대로 "Not Blank", 즉 **"공백이 아니어야 한다"**는 뜻입니다.
    // 문자열(String) 타입의 필드에 사용하며, 아래 3가지 경우를 모두 허용하지 않습니다.
    // 1. null
    // 2. 빈 문자열 ("")
    // 3. 오직 공백(whitespace)만으로 이루어진 문자열 (" ",  "  " 등)

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    private String author;

}