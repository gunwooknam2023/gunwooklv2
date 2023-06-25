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
    private final JwtUtil jwtUtil;

    // 게시글 작성 API
    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto, HttpServletRequest request) {
        User user = checkToken(request)
    }

    // 전체 게시글 목록 조회 API
    public List<PostResponseDto> getPost() {

    }


    // 선택한 게시글 조회 API
    public PostResponseDto getPost(Long id) {

    }

    //  선택한 게시글 수정 API
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto, HttpServletRequest request) {

    }

    // 선택한 게시글 삭제 API
    public void deletePost(Long id, HttpServletRequest request) {

    }

    // 토큰체크
    public User checkToken(HttpServletRequest request){
        String token = jwtUtil.resolveToken(request);4





    }
}
