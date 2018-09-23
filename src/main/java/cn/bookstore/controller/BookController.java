package cn.bookstore.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bookstore.entity.Book;
import cn.bookstore.entity.Page;
import cn.bookstore.service.BookService;

@Controller
public class BookController {
	
	@Autowired
//	@Qualifier(value="bookService")
	private BookService bookService;
	
	@RequestMapping("/index1")
	public String index1(Model model) {
		List<Book> books = this.bookService.findAll();
		model.addAttribute("books", books);
		
		return "index1";
	}
	
	@RequestMapping("/index")
	@SuppressWarnings("unchecked")
	public String index(HttpServletRequest request) {
		String pageno = request.getParameter("pageno");
		if(pageno == null)
			pageno = "1";
		Page<Book> page = bookService.findAllByPage(Integer.valueOf(pageno), 3);
		request.setAttribute("page", page);
		List<Book> bookList = page.getList();
		request.setAttribute("bookPages", bookList);
		List<Book> books = this.bookService.findAll();
		request.setAttribute("books", books);
		return "index";
	}
}
