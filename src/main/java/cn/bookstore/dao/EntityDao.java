package cn.bookstore.dao;

import java.io.Serializable;
import java.util.List;

/*
 * 通用数据访问接口
 */
public interface EntityDao<T,PK extends Serializable> {
	
	T load(PK id);
	
	T getById(PK id);
	
	List<T> findAll();
	
	List<T> findAllByPage(int offset, int length);
	
	Long getAllRowCount();
	
	void persist(T entity);
	
	void add(T entity);
	
	void update(T entity);
	
	void delete(PK id);
	
	void flush();
}
