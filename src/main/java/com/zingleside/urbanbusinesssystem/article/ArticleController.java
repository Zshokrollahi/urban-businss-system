package com.zingleside.urbanbusinesssystem.article;

import com.zingleside.urbanbusinesssystem.article.entity.Article;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "article managment")

public class ArticleController {

    private ArticleJDBCDateAccess articleJDBCDateAccess;

    public ArticleController(ArticleJDBCDateAccess articleJDBCDateAccess) {
        this.articleJDBCDateAccess = articleJDBCDateAccess;
    }

    @GetMapping("/article")
    List<Article> selectAllArticles(){
        return articleJDBCDateAccess.selectAlArticles();
    }

    @GetMapping("/article/id")
    boolean existsArticleWithID(Long id){
        return articleJDBCDateAccess.existWhithID(id);
    }

    @PostMapping("/article")
    public Article addNewArticle(@RequestBody Article article){
        return articleJDBCDateAccess.insertNewArticle(article);

    }
}
