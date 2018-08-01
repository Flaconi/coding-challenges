package com.flaconi.categoriesdemo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.flaconi.categoriesdemo.model.CategoryResponse;
import com.flaconi.categoriesdemo.services.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoriesControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CategoryService categoryService;

	@Test
	public void testSuccessResponseFromGetCategories() throws Exception {
		this.mvc.perform(get("/api/categories").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void testGetCategoryById() throws Exception {
		CategoryResponse category = new CategoryResponse(UUID.randomUUID(), "category 1", "slug 1", null, null, true, null, new Date(), null, new Date());
		when(categoryService.getCategoryByIdOrSlug(category.getId().toString())).thenReturn(category);

		this.mvc.perform(get("/api/categories/{idOrSlug}", category.getId().toString())).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(category.getId().toString())).andDo(print());
	}

	@Test
	public void testGetCategoryBySlug() throws Exception {
		CategoryResponse category = new CategoryResponse(UUID.randomUUID(), "category 1", "slug", null, null, true, null, new Date(), null, new Date());
		when(categoryService.getCategoryByIdOrSlug("slug")).thenReturn(category);

		this.mvc.perform(get("/api/categories/{idOrSlug}", "slug")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(category.getId().toString())).andDo(print());

	}

}