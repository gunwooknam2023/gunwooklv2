package com.sparta.gunwooklv2.controller;


import com.sparta.gunwooklv2.dto.LoginRequestDto;
import com.sparta.gunwooklv2.dto.SignupRequestDto;
import com.sparta.gunwooklv2.dto.StatusResult;
import com.sparta.gunwooklv2.entity.User;
import com.sparta.gunwooklv2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    // 회원가입 API
    @PostMapping("/signup")
    public StatusResult signup(@Valid @RequestBody SignupRequestDto signupRequestDto){
        User user = userService.signup(signupRequestDto);
        return new StatusResult("회원가입 성공", HttpStatus.OK.value());
    }

    // 로그인 API
    @ResponseBody
    @PostMapping("/login")
    public StatusResult login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){
        String token = userService.login(loginRequestDto, response);
        return new StatusResult("로그인 성공", HttpStatus.OK.value());
    }
}
