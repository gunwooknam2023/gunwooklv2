package com.sparta.gunwooklv2.service;

import com.sparta.gunwooklv2.dto.PostRequestDto;
import com.sparta.gunwooklv2.dto.PostResponseDto;
import com.sparta.gunwooklv2.entity.User;
import com.sparta.gunwooklv2.jwt.JwtUtil;
import com.sparta.gunwooklv2.repository.PostRepository;
import com.sparta.gunwooklv2.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    privat final JwtUtil jwtUtil;

    // 게시글 작성 API
    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto, HttpServletRequest request) {
        User user = checkToken
    }

    public List<PostResponseDto> getPost() {

    }


    public PostResponseDto getPost(Long id) {

    }

    public PostResponseDto updatePost(Long id, PostRequestDto requestDto, HttpServletRequest request) {

    }
}
