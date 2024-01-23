package com.zingleside.urbanbusinesssystem.article.api;

import com.zingleside.urbanbusinesssystem.article.dao.ArticleJDBCDateAccess;
import com.zingleside.urbanbusinesssystem.article.entity.Article;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/article/{id}")
    void updateArticle(@RequestBody Article article , @PathVariable("id") Long id){
        articleJDBCDateAccess.updateArticle(article , id );
        System.out.println("updated");
    }

    @DeleteMapping("/article/ {id}")
    void deleteArticle(@PathVariable("id") Long id ){

        articleJDBCDateAccess.deleteArticle(id);
    }
}
