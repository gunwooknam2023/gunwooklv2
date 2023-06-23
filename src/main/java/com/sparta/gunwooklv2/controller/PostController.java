package com.sparta.gunwooklv2.controller;


import com.sparta.gunwooklv2.dto.PostRequestDto;
import com.sparta.gunwooklv2.dto.PostResponseDto;
import com.sparta.gunwooklv2.dto.StatusResult;
import com.sparta.gunwooklv2.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @PostMapping("/posts") // 게시글 작성 API
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto, HttpServletRequest request){
        return postService.createPost(requestDto, request);
    }

    @GetMapping("/posts") // 전체 게시글 목록 조회 API
    public List<PostResponseDto> getPost(){
        return postService.getPost();
    }

    @GetMapping("/posts/{id}") // 선택한 게시글 조회 API
    public PostResponseDto getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PutMapping("/posts/{id}") //  선택한 게시글 수정 API
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto, HttpServletRequest request){
        return postService.updatePost(id, requestDto, request);
        )
    }

    @DeleteMapping("/posts/{id}") // 선택한 게시글 삭제 API
    public StatusResult.deletePost(@PathVariable Long id, )










}
