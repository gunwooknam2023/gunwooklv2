package com.sparta.gunwooklv2.dto;

import com.sparta.gunwooklv2.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
        private long id;
        private String title;
        private String contents;
        private String username;
        private LocalDateTime createAt;
        private LocalDateTime modifiedAt;

        public PostResponseDto(Post post){
            this.id = post.getId();
            this.title = post.getTitle();
            this.contents = post.getContents();
            this.username = post.getUsername();
            this.createAt = post.getCreatedAt();
            this.modifiedAt = post.getModifiedAt();
        }
}
