package com.zingleside.urbanbusinesssystem.article;

import com.zingleside.urbanbusinesssystem.advertising.entity.Advertising;
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
        return jdbcClient.sql("select * from article").query(Article.class).list();
    }



    @Override
    public Article insertNewArticle(Article article) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("insert into article(title,type) values (:title , :type)")
                .paramSource(article).update(keyHolder);
        Long id = (Long) keyHolder.getKeys().get("id");
        return jdbcClient.sql("select id,title,type from article  where id = :id")
                .param("id", id)
                .query(Article.class).single();

    }

    @Override
    public boolean existWhithID(Long id) {
        return jdbcClient.sql("select * from article where id = :id").param("id" ,id).paramSource(Article.class).equals(id);
    }
}
