package com.example.loginlivesession2.post.controller;

import com.example.loginlivesession2.post.dto.PostRequestDto;
import com.example.loginlivesession2.post.dto.PostResponseDto;
import com.example.loginlivesession2.post.dto.ResponseDto;
import com.example.loginlivesession2.post.repository.PostRepository;
import com.example.loginlivesession2.post.service.PostService;
import com.example.loginlivesession2.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    @PostMapping("/post")
    public ResponseDto<PostResponseDto> Post(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseDto.success(postService.post(postRequestDto, userDetails), "등록 성공");
    }

    @GetMapping("/post/{category}")
    public ResponseDto<List<PostResponseDto>> getCategoryPost(@PathVariable("category") String category) {
        System.out.println(category);
        return ResponseDto.success(postService.getCategoryPost(category), "등록 성공");
    }


    @GetMapping("/post/{postId}")
    public ResponseDto<PostResponseDto> getOnePost(@PathVariable Long postId) {
        return ResponseDto.success(postService.getOnePost(postId), "조회 성공");
    }

    @PutMapping("/post/{postId}")
    public ResponseDto<PostResponseDto> updatePost(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseDto.success(postService.updatePost(postId, postRequestDto, userDetails), "수정 완료");
    }

    @DeleteMapping("/post/{postId}")
    public ResponseDto<String> deletePost(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseDto.success(postService.deletePost(postId, userDetails), "삭제 성공");
    }
}
