package com.jeremy.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jeremy.books.models.Book;
import com.jeremy.books.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String index(@PathVariable("bookId") Long bookId, Model model) {
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book", book);
		
		return "index.jsp";
	}
}