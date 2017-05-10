/**
 * 
 */
package com.scart.jcart.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.jcart.entities.User;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

}
