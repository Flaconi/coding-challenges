package com.flaconi.categoriesdemo.services;

import java.util.List;

import javax.validation.Valid;

import com.flaconi.categoriesdemo.model.Category;
import com.flaconi.categoriesdemo.model.CategoryRequest;
import com.flaconi.categoriesdemo.model.CategoryResponse;

/**
 * @author Mohit.Saluja
 *
 */
public interface CategoryService {

	public @Valid Category createCategory(@Valid CategoryRequest category);

	public CategoryResponse getCategoryByIdOrSlug(String categoryId);

	public CategoryResponse getCategoryTreeById(String id);

	public List<CategoryResponse> getAllCategories();

	public Category updateCategoryVisibility(String categoryId, Boolean isVisible);

}
