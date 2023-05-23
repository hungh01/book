package com.example.book.Controller;


import com.example.book.Model.Book;
import com.example.book.services.BookService;
import com.example.book.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public String ShowAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(/*@Valid*/ @ModelAttribute("book") Book book/*, BindingResult bindingResult, Model model*/){
//        if(bindingResult.hasErrors()){
//            model.addAttribute("categories",categoryService.getAllCategory());
//            model.addAttribute("book",new Book());
//            return "book/add";
//        }
//        else {
            bookService.addBook(book);
            return "redirect:/books";
//        }
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id,Model model){
        Book editBook = null;
        for (Book book: bookService.getAllBooks())
            if(book.getId().equals(id))
                editBook = book;
        if(editBook!= null){
            model.addAttribute("book", editBook);
            model.addAttribute("categories", categoryService.getAllCategory());
            return "book/edit";
        }else
            return "not-found!";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
