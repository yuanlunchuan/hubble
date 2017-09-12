package com.hubble.entiy;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="un_register_API")
public class UnRegisterAPI implements Serializable{
	private static final long serialVersionUID = -7182969616775418472L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name = "api")
	private String api;
	
	@Column(name = "api_name")
	private String apiName;
	
	@Column(name = "method")
	private String method;
	
	@Column(name = "response")
	private String response;
	
	@Column(name = "param")
	private String param;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "invoke_count")
	private Integer invokeCount;
	
	@Column(name = "alive")
	private Boolean alive;
	
	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getInvokeCount() {
		return invokeCount;
	}

	public void setInvokeCount(Integer invokeCount) {
		this.invokeCount = invokeCount;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}
}
