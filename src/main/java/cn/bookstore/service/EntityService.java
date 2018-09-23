package cn.bookstore.service;

import java.io.Serializable;
import java.util.List;

import cn.bookstore.entity.Page;

public interface EntityService<T,PK extends Serializable> {
	
	void add(T entity);
	
	void delete(PK id);
	
	T getById(PK id);
	
	List<T> findAll();
	
	Page findAllByPage(int currentPage, int pageSize);
	
	Long getAllRowCount();
	
	void update(T entity);
}
