/**
 * 
 */
package com.scart.core.newsletter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.core.entities.NewsLetterSubscriber;

/**
 * @author Prabhakar Jha
 *
 */
public interface NewsLetterSubscriberRepository extends JpaRepository<NewsLetterSubscriber, Integer>{
	
}
