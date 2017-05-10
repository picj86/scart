/**
 * 
 */
package com.scart.jcart.newsletter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scart.jcart.entities.NewsLetterSubscriber;

/**
 * @author Prabhakar Jha
 *
 */
@Service
@Transactional
public class NewsLetterSubscriberService {
	@Autowired 
	NewsLetterSubscriberRepository newsLetterSubscriberRepository;
	
	public List<NewsLetterSubscriber> getAllNewsLetterSubscriber(){
		return newsLetterSubscriberRepository.findAll();
	}
	
	public NewsLetterSubscriber createNewsLetterSubscriber(NewsLetterSubscriber newsLetter){
		return newsLetterSubscriberRepository.save(newsLetter);
	}

}
