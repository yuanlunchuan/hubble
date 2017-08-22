package com.hubble.util;

import java.io.Serializable;
import java.util.IdentityHashMap;
import java.util.Map;

public class Enquiry implements Serializable {

	private static final long serialVersionUID = -6469951401084655686L;

	// 查询参数
	private Map<String, Object> searchParams = new IdentityHashMap<String, Object>() {
		private static final long serialVersionUID = -761223595036640586L;
	};

	// 页数
	private int pageNumber = 1;

	// 分页显示的大小
	private int pageSize = 10;

	// 排序类型：aoto代表自动，否则其值为排序字段属性名
	private String sortType = "auto";

	// 排序方式：asc代表顺序，desc代表逆序
	private String direction = "desc";

	public Map<String, Object> getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(Map<String, Object> params) {
		searchParams.putAll(params);
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
