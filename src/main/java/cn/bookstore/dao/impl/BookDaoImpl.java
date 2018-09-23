package cn.bookstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.bookstore.dao.BookDao;
import cn.bookstore.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public Book load(Integer id) {
		return (Book) this.getSession().load(Book.class, id);
	}

	@Override
	public Book getById(Integer id) {
		return (Book) this.getSession().get(Book.class, id);
	}

	@Override
	public List<Book> findAll() {
		return this.getSession().createQuery("from Book").list();
	}

	@Override
	public void persist(Book entity) {
		this.getSession().persist(entity);
	}

	@Override
	public void add(Book entity) {
		this.getSession().save(entity);
	}

	@Override
	public void update(Book entity) {
		this.getSession().update(entity);
	}

	@Override
	public void delete(Integer id) {
		Book book = this.getById(id);
		this.getSession().delete(book);
	}

	@Override
	public void flush() {
		this.getSession().flush();
	}
	
	/*
	 * 分页 查询
	 */
	@Override
	public List<Book> findAllByPage(int offset, int length) {
		List<Book> bookList = null;
		Query query = this.getSession().createQuery("from Book");
		query.setFirstResult(offset);
		query.setMaxResults(length);
		bookList = query.list();
		return bookList;
	}
	
	/*
	 * 总记录数
	 */
	@Override
	public Long getAllRowCount() {
		Query query = this.getSession().createQuery("select count(*) from Book");
		return Long.parseLong(query.uniqueResult().toString());
	}


}
