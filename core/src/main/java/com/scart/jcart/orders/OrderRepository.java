/**
 * 
 */
package com.scart.jcart.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scart.jcart.entities.Order;

/**
 * @author Siva
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer>
{
	Order findByOrderNumber(String orderNumber);
}
