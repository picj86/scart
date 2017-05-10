/**
 * 
 */
package com.scart.core.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.core.entities.Category;

/**
 * @author Prabhakar Jha
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category getByName(String name);

}
