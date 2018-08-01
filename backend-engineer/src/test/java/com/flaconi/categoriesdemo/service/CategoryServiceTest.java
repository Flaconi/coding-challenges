package com.flaconi.categoriesdemo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flaconi.categoriesdemo.model.Category;
import com.flaconi.categoriesdemo.model.CategoryRequest;
import com.flaconi.categoriesdemo.model.CategoryResponse;
import com.flaconi.categoriesdemo.repository.CategoryDAO;
import com.flaconi.categoriesdemo.services.impl.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest {

	@Mock
	private CategoryDAO categoryDAO;

	@InjectMocks
	private CategoryServiceImpl categoryService;

	@Test
	public void testGetAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category(UUID.randomUUID(), "category 1", "slug 1", null, null, true, new Date(), new Date()));
		categories.add(new Category(UUID.randomUUID(), "category 2", "slug 2", null, null, true, new Date(), new Date()));
		categories.add(new Category(UUID.randomUUID(), "category 3", "slug 3", null, null, false, new Date(), new Date()));
		when(categoryDAO.findAll()).thenReturn(categories);

		List<CategoryResponse> result = categoryService.getAllCategories();
		assertEquals(3, result.size());
	}

	@Test
	public void testGetCategoryById() {
		Category category = new Category(UUID.randomUUID(), "category 1", "slug 1", null, new HashSet<>(), true, new Date(), new Date());
		when(categoryDAO.findById(category.getId())).thenReturn(Optional.of(category));
		when(categoryDAO.findByIdOrSlug(category.getId(), category.getId().toString())).thenReturn(Optional.of(category));
		CategoryResponse result = categoryService.getCategoryByIdOrSlug(category.getId().toString());
		assertEquals(category.getId(), result.getId());
		assertEquals("category 1", result.getName());
		assertEquals("slug 1", result.getSlug());
		assertEquals(true, result.getIsVisible());
	}

	@Test
	public void testGetCategoryBySlug() {
		Category category = new Category(UUID.randomUUID(), "category 1", "slug 1", null, new HashSet<>(), true, new Date(), new Date());
		when(categoryDAO.findBySlug("slug 1")).thenReturn(Optional.of(category));
		CategoryResponse result = categoryService.getCategoryByIdOrSlug("slug 1");
		assertEquals(category.getId(), result.getId());
		assertEquals("category 1", result.getName());
		assertEquals("slug 1", result.getSlug());
		assertEquals(true, result.getIsVisible());
	}

}