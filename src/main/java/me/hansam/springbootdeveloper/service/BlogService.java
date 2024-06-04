package me.hansam.springbootdeveloper.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.hansam.springbootdeveloper.domain.Article;
import me.hansam.springbootdeveloper.dto.AddArticleRequest;
import me.hansam.springbootdeveloper.repository.BlogRepository;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request){ //Article 대신 AddArticleRequest로 받는 이유???
        return blogRepository.save(request.toEntity());
    }
}
