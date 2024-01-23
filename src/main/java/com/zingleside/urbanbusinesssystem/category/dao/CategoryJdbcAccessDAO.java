package com.zingleside.urbanbusinesssystem.category.dao;

import com.zingleside.urbanbusinesssystem.advertising.model.Advertising;
import com.zingleside.urbanbusinesssystem.category.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CategoryJdbcAccessDAO implements CategoryDAO{
    @Override
    public List<Category> selectALlCategories() {
        return null;
    }

    @Override
    public Optional<Category> selectcategoryByID(Long id) {
        return Optional.empty();
    }

    @Override
    public Category insertCategory(Advertising advertising) {
        return null;
    }
}
