package com.scart.jcart.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="adminnotification_inbox")
public class AdminNotification {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer notification_id;
	
	@Column(nullable=false)
	@NotEmpty
	private String severity;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_added;
	
	@Column(nullable=false)
	@NotEmpty
	private String title;
	
	private String description;
	private String url;
	private Integer is_read;
	private Integer is_remove;
	public Integer getNotification_id() {
		return notification_id;
	}
	public void setNotification_id(Integer notification_id) {
		this.notification_id = notification_id;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public Date getDate_added() {
		return date_added;
	}
	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIs_read() {
		return is_read;
	}
	public void setIs_read(Integer is_read) {
		this.is_read = is_read;
	}
	public Integer getIs_remove() {
		return is_remove;
	}
	public void setIs_remove(Integer is_remove) {
		this.is_remove = is_remove;
	}
}
