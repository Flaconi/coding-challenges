package com.flaconi.categoriesdemo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "creationTime", "updatedTime" }, allowGetters = true)
public class CategoryResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UUID id;

	@NotBlank
	private String name;

	@NotBlank
	private String slug;

	private String parentCategory;

	private Set<CategoryResponse> subCategories = new HashSet<>();

	@NotNull
	private Boolean isVisible;

	private Date creationTime;

	private Date updationTime;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<CategoryResponse> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<CategoryResponse> subCategories) {
		this.subCategories = subCategories;
	}

	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getUpdationTime() {
		return updationTime;
	}

	public void setUpdationTime(Date updationTime) {
		this.updationTime = updationTime;
	}

	public CategoryResponse(UUID id, @NotBlank String name, @NotBlank String slug, String parentCategory, Set<CategoryResponse> subCategories, @NotNull Boolean isVisible) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.parentCategory = parentCategory;
		this.subCategories = subCategories;
		this.isVisible = isVisible;
	}

	public CategoryResponse() {
		super();
	}

}