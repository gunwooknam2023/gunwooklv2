package com.sparta.gunwooklv2.service;

import com.sparta.gunwooklv2.dto.PostRequestDto;
import com.sparta.gunwooklv2.dto.PostResponseDto;
import com.sparta.gunwooklv2.entity.Post;
import com.sparta.gunwooklv2.entity.User;
import com.sparta.gunwooklv2.jwt.JwtUtil;
import com.sparta.gunwooklv2.repository.PostRepository;
import com.sparta.gunwooklv2.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        User user = checkToken(request);

        if(user == null){
            throw new IllegalArgumentException("인증되지 않은 사용자입니다.");
        }
        Post post = new Post(requestDto, user);
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    // 전체 게시글 목록 조회 API
    @Transactional
    public List<PostResponseDto> getPost() {
        List<Post> posts = postRepository.findAllByOrderByModifiedAtDesc();
        List<PostResponseDto> postResponseDto = new ArrayList<>();

        for(Post post : posts){
            postResponseDto.add(new PostResponseDto(post));
        }

        return postResponseDto;
    }

    @Transactional
    // 선택한 게시글 조회 API
    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 일치하지 않습니다")
                );

        return new PostResponseDto(post);
    }

    @Transactional
    //  선택한 게시글 수정 API
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto, HttpServletRequest request) {

        // 토큰 체크
        User user = checkToken(request);

        if(user == null){
            throw new IllegalArgumentException("인증되지 않은 사용자입니다.");
        }

        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 글이 존재하지 않습니다.")
                );

        if(!post.getUser().equals(user)){
            throw new IllegalArgumentException("글 작성자가 아닙니다.");
        }

        post.update(requestDto);
        return new PostResponseDto(post);
    }

    @Transactional
    // 선택한 게시글 삭제 API
    public void deletePost(Long id, HttpServletRequest request) {

        // 토큰 체크
        User user = checkToken(request);

        if(user == null){
            throw new IllegalArgumentException("인증되지 않은 사용자입니다.");
        }

        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 글이 존재하지 않습니다.")
                );

        if(post.getUser().equals(user)){
            postRepository.delete(post);
        }
    }

    // 토큰체크
    public User checkToken(HttpServletRequest request){

        // 클라이언트의 요청에서 JWT토큰 가지고 오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;
        
        // 추출된 토큰이 null이 아닐경우 토큰 유효성 검사 실행
        if(token != null){ 
            // JWT 토큰 유효성 검사
            if(jwtUtil.validateToken(token)){
                // 토큰이 유효한 경우에 getUserInfoFromToken을 사용하여 토큰에서 사용자 정보 추출
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                // 토큰이 존재하지 않으면 Token Error라는 메세지를 출력하며 예외를 발생시킨다.
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다")
                    );
            return user;

        }
        // 토큰이 없을경우 null을 반환해준다.
        return null;
    }
}
