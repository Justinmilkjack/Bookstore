package cn.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bookstore.dao.BookDao;
import cn.bookstore.entity.Book;
import cn.bookstore.entity.Page;
import cn.bookstore.service.BookService;

@Transactional
//@Service(value="bookService")
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public void add(Book entity) {
		this.bookDao.add(entity);
	}

	@Override
	public void delete(Integer id) {
		this.bookDao.delete(id);
	}

	@Override
	public Book getById(Integer id) {
		return this.bookDao.getById(id);
	}

	@Override
	public List<Book> findAll() {
		return this.bookDao.findAll();
	}

	@Override
	public void update(Book entity) {
		this.bookDao.update(entity);
	}

	/*
	 * 分页查询
	 */
	@Override
	public Page findAllByPage(int currentPage, int pageSize) {
		Page<Book> page = new Page<Book>();
		int allRow = bookDao.getAllRowCount().intValue();
		int offset = page.countOffset(currentPage, pageSize);
		List<Book> bookList = bookDao.findAllByPage(offset, pageSize);
		page.setPageno(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(bookList);
		return page;
	}

	/*
	 * 总记录数
	 */
	@Override
	public Long getAllRowCount() {
		return bookDao.getAllRowCount();
	}

	
	
	
}
