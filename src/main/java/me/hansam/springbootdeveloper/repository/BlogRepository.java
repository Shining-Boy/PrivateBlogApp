package me.hansam.springbootdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.hansam.springbootdeveloper.domain.Article;

public interface BlogRepository extends JpaRepository<Article, Long>{

    
} 
