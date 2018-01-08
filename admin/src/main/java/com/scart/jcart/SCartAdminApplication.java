/**
 * 
 */
package com.scart.jcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Siva
 *
 */
@SpringBootApplication
public class SCartAdminApplication
{

	public static void main(String[] args)
	{
		// This will enable debug for auto wiring
		//SpringApplication.run(JCartAdminApplication.class, "--debug");
		SpringApplication.run(SCartAdminApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
