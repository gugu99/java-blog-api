package com.gugu.blog.service;

import com.gugu.blog.domain.Article;
import com.gugu.blog.dto.AddArticleRequest;
import com.gugu.blog.dto.ArticleResponse;
import com.gugu.blog.dto.UpdateArticleRequest;
import com.gugu.blog.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 블로그 글 전체 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 블로그 글 상세조회
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 블로그 글 삭제
    public  void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 블로그 글 수정
    @Transactional //트랜잭션 메서드 - 실행하는 동안 해당 엔티티가 변경되는지 체크한다.(Dirty Checking)
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
