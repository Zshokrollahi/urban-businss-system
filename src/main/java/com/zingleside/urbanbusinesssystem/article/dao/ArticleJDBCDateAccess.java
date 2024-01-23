package com.zingleside.urbanbusinesssystem.article.dao;

import com.zingleside.urbanbusinesssystem.article.entity.Article;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleJDBCDateAccess implements ArticleDAO {

    private JdbcClient jdbcClient;

    public ArticleJDBCDateAccess(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    @Override
    public List<Article> selectAlArticles() {
        return jdbcClient.sql("select * from articles").query(Article.class).list();
    }


    @Override
    public Article insertNewArticle(Article article) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("insert into articles(title, description, writer, created_at) values (:title , :description , :writer , :created_at)")
                .paramSource(article).update(keyHolder);
        Long id = (Long) keyHolder.getKeys().get("id");
        return jdbcClient.sql("select id, title, description, writer, created_at from articles  where id = :id")
                .param("id", id)
                .query(Article.class).single();

    }

    @Override
    public boolean existWhithID(Long id) {
        return jdbcClient.sql("select count(id)>0 from articles where id = :id").param("id", id).query(Boolean.class).single();
    }

    @Override
    public void deleteArticle(Long id) {
        jdbcClient.sql("delete  from articles where id = :id").param("id", id).update();
        System.out.println("record deleted");
    }

    @Override
    public void updateArticle(Article article, Long id) {
        jdbcClient.sql("update articles set title = :title where id = :id").param("id", id).param("title", article.title()).update();
    }


}
