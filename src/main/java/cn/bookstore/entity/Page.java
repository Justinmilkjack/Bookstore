package cn.bookstore.entity;

import java.util.List;

public class Page<E> {
	// 结果集
	private List<E> list;
	// 记录总数
	private int totalRecords;
	// 每页记录数
	private int pageSize;
	// 第几页
	private int pageno;
	
	/*
	 * 总页数
	 */
	public int getTotalPages() {
		return (totalRecords+pageSize-1)/pageSize;
	}
	
	/*
	 * 当前页的第一个记录数
	 */
	public int countOffset(int currentPage, int pageSize) {
		return pageSize*(currentPage-1);
	}
	
	/*
	 * 首页
	 */
	public int getTopPageno() {
		return 1;
	}
	
	/*
	 * 尾页
	 */
	public int getBottomPageno() {
		return getTotalPages();
	}
	
	/*
	 * 上一页
	 */
	public int getPreviousPageno() {
		if(pageno <= 1)
			return 1;
		return pageno - 1;
	}
	
	/*
	 * 下一页
	 */
	public int getNextPageno() {
		if(pageno >= getBottomPageno())
			return getBottomPageno();
		return pageno + 1;
	}
	
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
}
