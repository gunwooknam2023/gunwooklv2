package com.sparta.gunwooklv2.dto;

import com.sparta.gunwooklv2.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
        private long id; // 게시글 번호
        private String title; // 게시글 제목
        private String contents; // 게시글 내용
        private String username; // 유저이름
        private LocalDateTime createAt; // 생성된 시간
        private LocalDateTime modifiedAt; // 수정된 시간

        public PostResponseDto(Post post){
            this.id = post.getId(); // post에서 id 추출하여 대입
            this.title = post.getTitle(); // post에서 제목 추출하여 대입
            this.contents = post.getContents(); // post에서 내용 추출하여 대입
            this.username = post.getUsername(); // post에서 유저이름 추출하여 대입
            this.createAt = post.getCreatedAt(); // post에서 생성시간 추출하여 대입
            this.modifiedAt = post.getModifiedAt(); // post에서 수정시간 추출하여 대입
        }
}
