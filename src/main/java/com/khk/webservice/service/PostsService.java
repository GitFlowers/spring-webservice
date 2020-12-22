package com.khk.webservice.service;

import com.khk.webservice.domain.PostsRepository;
import com.khk.webservice.dto.PostsMainResponseDto;
import com.khk.webservice.dto.posts.PostsSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/*
* 서비스 클래스에서 로직과 트랜잭션을 관리
* 컨트롤러에서 View 와 연동되는 부분을 관리
* */
@Service
public class PostsService {
    private PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }

}
