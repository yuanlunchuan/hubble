package com.hubble.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 序列化返回分页
 *
 * @param <T>
 */
public class PageHelper<T> implements Serializable {
	private static final long serialVersionUID = 4504220604936445452L;

	private List<T> content = new ArrayList<T>();
	private long total;// 总条数
	private long totalPage;// 总页数

	public PageHelper() {
		super();
	}

	public PageHelper(List<T> content, long total) {
		if (null == content) {
			throw new IllegalArgumentException("Content must not be null!");
		}
		this.content.addAll(content);
		this.total = total;
	}

	public PageHelper(List<T> content) {
		this(content, null == content ? 0 : content.size());
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

}
