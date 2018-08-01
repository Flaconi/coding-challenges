package com.flaconi.categoriesdemo.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flaconi.categoriesdemo.exception.InvalidInputParametersException;
import com.flaconi.categoriesdemo.exception.ResourceNotFoundException;
import com.flaconi.categoriesdemo.exception.SlugAlreadyExistsException;
import com.flaconi.categoriesdemo.model.Category;
import com.flaconi.categoriesdemo.model.CategoryRequest;
import com.flaconi.categoriesdemo.model.CategoryResponse;
import com.flaconi.categoriesdemo.repository.CategoryDAO;
import com.flaconi.categoriesdemo.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private static final String CATEGORY = "Category";
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public @Valid Category createCategory(@Valid CategoryRequest categoryRequest) {
		if (categoryDAO.findBySlug(categoryRequest.getSlug()).isPresent()) {
			throw new SlugAlreadyExistsException();
		}
		Category category = new Category();
		category.setName(categoryRequest.getName());
		category.setSlug(categoryRequest.getSlug());
		category.setIsVisible(categoryRequest.getIsVisible());
		Category parentCategory = null;
		if (categoryRequest.getParentCategory() != null) {
			UUID parentCategoryUUID = null;
			try {
				parentCategoryUUID = UUID.fromString(categoryRequest.getParentCategory());
			} catch (IllegalArgumentException illegalArgumentException) {
				// input id is invalid, throwing InvalidInputParametersException
				throw new InvalidInputParametersException("Parent Category", "id", categoryRequest.getParentCategory());
			}
			parentCategory = categoryDAO.findById(parentCategoryUUID).orElseThrow(() -> new ResourceNotFoundException("Parent Category", "id", categoryRequest.getParentCategory()));
		}
		category.setParentCategory(parentCategory);
		return categoryDAO.save(category);
	}

	@Override
	public CategoryResponse getCategoryByIdOrSlug(String idOrSlug) {
		UUID id = null;
		try {
			id = UUID.fromString(idOrSlug);
		} catch (IllegalArgumentException illegalArgumentException) {
			// ignoring this exception and assuming input parameter is slug
		}
		Category category = null;
		if (id != null)
			category = categoryDAO.findByIdOrSlug(id, idOrSlug).orElseThrow(() -> new ResourceNotFoundException(CATEGORY, "id", idOrSlug));
		else
			category = categoryDAO.findBySlug(idOrSlug).orElseThrow(() -> new ResourceNotFoundException(CATEGORY, "id", idOrSlug));
		return mapCategory(category);
	}

	@Override
	public CategoryResponse getCategoryTreeById(String id) {
		UUID uuid = null;
		try {
			uuid = UUID.fromString(id);
		} catch (IllegalArgumentException illegalArgumentException) {
			// input id is invalid, throwing ResourceNotFoundException
			throw new ResourceNotFoundException(CATEGORY, "id", id);
		}
		Category category = null;
		if (uuid != null) {
			category = categoryDAO.findById(UUID.fromString(id)).orElseThrow(() -> new ResourceNotFoundException(CATEGORY, "id", id));
			return mapCategoryTree(category);
		}
		return null;
	}

	@Override
	public List<CategoryResponse> getAllCategories() {
		List<CategoryResponse> response = new ArrayList<>();
		List<Category> categoriesList = categoryDAO.findAll();

		for (Iterator<Category> iterator = categoriesList.iterator(); iterator.hasNext();) {
			Category category = iterator.next();
			response.add(mapCategoryTree(category));
		}

		return response;
	}

	@Override
	public Category updateCategoryVisibility(String categoryId, Boolean isVisible) {
		Category categoryDetails = categoryDAO.findById(UUID.fromString(categoryId)).orElseThrow(() -> new ResourceNotFoundException(CATEGORY, "id", categoryId));
		categoryDetails.setIsVisible(isVisible);
		return categoryDAO.save(categoryDetails);
	}

	/**
	 * This method creates CategoryResponse object from Category object and maps
	 * sub categories available under provided category
	 * 
	 * @param category
	 * @return
	 */
	private CategoryResponse mapCategory(Category category) {
		CategoryResponse response = createCategoryResponse(category);

		Set<CategoryResponse> categoryResponses = new HashSet<>();
		CategoryResponse subCategory;
		Set<Category> subCategories = category.getSubCategories();
		if (subCategories != null) {
			for (Iterator<Category> iterator = subCategories.iterator(); iterator.hasNext();) {
				Category category2 = iterator.next();
				subCategory = createCategoryResponse(category2);
				categoryResponses.add(subCategory);
			}
		}
		response.setSubCategories(categoryResponses);
		return response;
	}

	/**
	 * This method creates CategoryResponse object from Category object and
	 * recursively maps subCategories of categories
	 * 
	 * @param category
	 * @return
	 */
	private CategoryResponse mapCategoryTree(Category category) {
		CategoryResponse response = createCategoryResponse(category);

		Set<CategoryResponse> categoryResponses = new HashSet<>();
		CategoryResponse subCategory;
		Set<Category> subCategories = category.getSubCategories();
		if (subCategories != null) {
			for (Iterator<Category> iterator = subCategories.iterator(); iterator.hasNext();) {
				Category category2 = iterator.next();
				subCategory = mapCategoryTree(category2);
				categoryResponses.add(subCategory);
			}
		}
		response.setSubCategories(categoryResponses);
		return response;
	}

	/**
	 * This method creates CategoryResponse object from Category object
	 * 
	 * @param category
	 * @return
	 */
	private CategoryResponse createCategoryResponse(Category category) {
		CategoryResponse response = new CategoryResponse();
		response.setId(category.getId());
		response.setName(category.getName());
		response.setSlug(category.getSlug());
		response.setIsVisible(category.getIsVisible());
		response.setParentCategory(category.getParentCategory() != null ? category.getParentCategory().getId().toString() : null);
		return response;
	}

}