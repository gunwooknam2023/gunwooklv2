package com.sparta.gunwooklv2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {

    @NotBlank
    @Size(min =4, max = 10, message = "4~10자 사이")
    @Pattern(regexp = "^[a-z0-9]*$",message = "알파벳 소문자(a~z), 숫자(0~9)")
    private String username;

    @NotBlank
    @Size(min = 8, max = 15, message = "8~15자 사이")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "알파벳 소문자(a~z),알파벳 대문자(A~Z), 숫자(0~9)")
    private String password;

}
