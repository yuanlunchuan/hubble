package com.hubble.entiy;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "i_contact_info")
public class ContactInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Email(message = "邮箱格式不正确")
	@NotEmpty(message = "邮箱不能为空")
	@Column(name = "email")
	private String email;

	@NotNull(message = "电话号码不能为空")
	@Column(name = "phone_num")
	private String phonenum;

	@NotEmpty(message = "主题不能为空")
	@Column(name = "subject")
	private String subject;

	@NotEmpty(message = "内容不能为空")
	@Column(name = "content")
	private String content;

	@Column(name = "createdAt")
	private Date createdAt;

	@Column(name = "updatedAt")
	private Date updatedAt;

	@Column(name = "alive")
	private Integer alive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getAlive() {
		return alive;
	}

	public void setAlive(Integer alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "ContactInfo [id=" + id + ", email=" + email + ", phonenum=" + phonenum + ", subject=" + subject
				+ ", content=" + content + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", alive=" + alive
				+ "]";
	}

}
