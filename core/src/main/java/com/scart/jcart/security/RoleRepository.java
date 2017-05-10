/**
 * 
 */
package com.scart.jcart.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.jcart.entities.Role;

/**
 * @author Siva
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

	Role findByName(String name);

}
