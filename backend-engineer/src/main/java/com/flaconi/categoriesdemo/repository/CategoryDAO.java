package com.flaconi.categoriesdemo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flaconi.categoriesdemo.model.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, UUID> {

	Optional<Category> findBySlug(String slug);

    @Query("SELECT category FROM Category category WHERE category.id = ?1 OR LOWER(category.slug) = LOWER(?2)")
	Optional<Category> findByIdOrSlug(UUID id, String slug);

}