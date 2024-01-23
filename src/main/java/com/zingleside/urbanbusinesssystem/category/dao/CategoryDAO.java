package com.zingleside.urbanbusinesssystem.category.dao;

import com.zingleside.urbanbusinesssystem.advertising.model.Advertising;
import com.zingleside.urbanbusinesssystem.category.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDAO {

    List<Category> selectALlCategories();

    Optional<Category> selectcategoryByID(Long id);

    Category insertCategory(Advertising advertising);
}
