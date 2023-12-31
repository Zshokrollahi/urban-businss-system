package com.zingleside.urbanbusinesssystem.article;

import com.zingleside.urbanbusinesssystem.article.entity.Article;

import java.util.List;

public interface ArticleDAO {

    List<Article> selectAlArticles();
    Article insertNewArticle(Article article);

    boolean existWhithID(Long id);
}
