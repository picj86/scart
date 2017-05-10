/**
 * 
 */
package com.scart.core.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.core.entities.Role;

/**
 * @author Prabhakar Jha
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

	Role findByName(String name);

}
