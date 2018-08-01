package com.flaconi.categoriesdemo.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flaconi.categoriesdemo.model.Category;
import com.flaconi.categoriesdemo.model.CategoryRequest;
import com.flaconi.categoriesdemo.model.CategoryResponse;
import com.flaconi.categoriesdemo.model.UpdateVisibilityRequest;
import com.flaconi.categoriesdemo.services.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Value("${resourceMaxAge}")
	private int resourceMaxAge;

	// Create a new Category
	@PostMapping("/categories")
	public @Valid Category createCategory(@Valid @RequestBody CategoryRequest category) {
		return categoryService.createCategory(category);
	}

	// Get a Single Category by id or slug
	@GetMapping("/categories/{idOrSlug}")
	public CategoryResponse getCategoryByIdOrSlug(@PathVariable(value = "idOrSlug") String idOrSlug) {
		return categoryService.getCategoryByIdOrSlug(idOrSlug);
	}

	// Get tree of children/s under a specific category
	@GetMapping("/categoriesTree/{id}")
	public CategoryResponse getCategoryTreeById(@PathVariable(value = "id") String id) {
		return categoryService.getCategoryTreeById(id);
	}

	// Get All Categories
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryResponse>> getAllCategories() {
		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(resourceMaxAge, TimeUnit.SECONDS)).body(categoryService.getAllCategories());
	}

	// Update visibility of a Category
	@PatchMapping("/categories/{id}")
	public Category updateCategoryVisibility(@PathVariable(value = "id") String categoryId, @RequestBody UpdateVisibilityRequest request) {
		return categoryService.updateCategoryVisibility(categoryId, request.getIsVisible());
	}

}