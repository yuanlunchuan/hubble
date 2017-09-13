package com.hubble.entiy;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "i_users")
public class User implements Serializable {
	private static final long serialVersionUID = -8869037297365896519L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private Integer status;// 激活状态

	@Column(name = "validate_code")
	private String validateCode;// 激活码

	@Past
	@Column(name = "register_time")
	private Date registerTime;// 注册时间

	// @Column(name="createdAt")
	// private Date createdAt;
	//
	// @Column(name="updatedAt")
	// private Date updatedAt;
	//
	// @Column(name="alive")
	// private boolean alive;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	@Transient
	public Date getLastActivateTime() {
		Calendar cl = Calendar.getInstance();
		cl.setTime(registerTime);
		cl.add(Calendar.DATE, 2);

		return (Date) cl.getTime();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", status=" + status
				+ ", validateCode=" + validateCode + "]";
	}

}