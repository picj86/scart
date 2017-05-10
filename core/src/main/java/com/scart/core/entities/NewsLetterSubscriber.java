/**
 * 
 */
package com.scart.core.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Prabhakar Jha
 *
 */
@Entity
@Table(name="newsletter_subscriber")
public class NewsLetterSubscriber implements Serializable{

	private static final long serialVersionUID = 5968962292461433953L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer subscriber_id;
	@Column
	private Timestamp change_status_at;
	@Column
	private Integer customer_id;
	@Column(name = "subscriber_email")
	private String subscriber_email;
	@Column
	private Integer subscriber_status;
	@Column
	private String subscriber_confirm_code;
	
	public NewsLetterSubscriber(){}
	
	
	
	public Integer getSubscriber_id() {
		return subscriber_id;
	}
	public void setSubscriber_id(Integer subscriber_id) {
		this.subscriber_id = subscriber_id;
	}
	public Timestamp getChange_status_at() {
		return change_status_at;
	}
	public void setChange_status_at(Timestamp change_status_at) {
		this.change_status_at = change_status_at;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getSubscriber_email() {
		return this.subscriber_email;
	}
	public void setSubscriber_email(String subscriber_email) {
		this.subscriber_email = subscriber_email;
	}
	public Integer getSubscriber_status() {
		return subscriber_status;
	}
	public void setSubscriber_status(Integer subscriber_status) {
		this.subscriber_status = subscriber_status;
	}
	public String getSubscriber_confirm_code() {
		return subscriber_confirm_code;
	}
	public void setSubscriber_confirm_code(String subscriber_confirm_code) {
		this.subscriber_confirm_code = subscriber_confirm_code;
	}
}
