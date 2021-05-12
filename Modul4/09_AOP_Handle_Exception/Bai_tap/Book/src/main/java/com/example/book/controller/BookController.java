package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.OrderBook;
import com.example.book.service.BookService;
import com.example.book.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    OrderBookService orderBookService;
    @GetMapping
    public String showList(Model model, @CookieValue(value = "view", defaultValue = "0") Long count,
                           HttpServletRequest request, HttpServletResponse response){
        count++;
        request.getSession().setAttribute("count", count);
        Cookie cookie = new Cookie("view", count.toString());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        model.addAttribute("bookList", bookService.findAll());
        return "list";
    }

    @GetMapping("borrow/{id}")
    public String viewBorrowBook(@PathVariable int id, Model model){
        if(orderBookService.findById(orderBookService.createId()) != null){
            return "redirect:/borrow/{id}";
        }else {
            model.addAttribute("orderBook", new OrderBook(orderBookService.createId(), bookService.findById(id)));
            return "borrow";
        }
    }

    @GetMapping("save")
    public String save(@ModelAttribute OrderBook orderBook){
        Book book = bookService.findById(orderBook.getBook().getId());
        book.setQuantity(book.getQuantity() - 1);
        bookService.save(book);
        orderBookService.save(orderBook);
        return "redirect:/";
    }

    @GetMapping("return/{id}")
    public String viewReturnBook(@PathVariable int id, Model model){
        model.addAttribute("orderBook", new OrderBook(0, bookService.findById(id)));
        return "view";
    }

    @GetMapping("deleteContract")
    public String delete(@Valid @ModelAttribute OrderBook orderBook, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/view";
        }
        if(orderBookService.isEmpty(orderBook)){
            orderBookService.delete(orderBookService.findById(orderBook.getId()));
            Book book = bookService.findById(orderBook.getBook().getId());
            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);
            return "redirect:/";
        }else {
            model.addAttribute("message", "not found");
            return "/view";
        }
    }
}
