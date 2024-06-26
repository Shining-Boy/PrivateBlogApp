package me.hansam.springbootdeveloper.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.hansam.springbootdeveloper.domain.Article;
import me.hansam.springbootdeveloper.dto.AddArticleRequest;
import me.hansam.springbootdeveloper.dto.UpdateArticleRequest;
import me.hansam.springbootdeveloper.repository.BlogRepository;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request){ //Article 대신 AddArticleRequest로 받는 이유???
        return blogRepository.save(request.toEntity());
    }

    //블로그 글 목록 조회 메서드
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    //블로그 글 조회
    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //블로그 글 삭제
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    //블로그 글 수정
    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
