/**
 * 
 */
package com.scart.core.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.core.entities.Order;

/**
 * @author Prabhakar Jha
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer>
{
	Order findByOrderNumber(String orderNumber);
}
