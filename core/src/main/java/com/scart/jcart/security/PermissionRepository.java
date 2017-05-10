/**
 * 
 */
package com.scart.jcart.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.jcart.entities.Permission;

/**
 * @author Siva
 *
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer>
{

}
