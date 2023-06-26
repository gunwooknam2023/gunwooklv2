package com.sparta.gunwooklv2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {

    private String username; // 유저이름
    private String password; // 비밀번호
}
