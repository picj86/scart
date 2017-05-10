/**
 * 
 */
package com.scart.jcart.newsletter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.jcart.entities.NewsLetterSubscriber;

/**
 * @author pj0014676
 *
 */
public interface NewsLetterSubscriberRepository extends JpaRepository<NewsLetterSubscriber, Integer>{
	
}
