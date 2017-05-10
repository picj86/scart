/**
 * 
 */
package com.scart.core.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.core.entities.Permission;

/**
 * @author Prabhakar Jha
 *
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer>
{

}
