/**
 * 
 */
package com.scart.core.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.core.entities.User;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

}
