package com.example.book.Controller;


import com.example.book.Model.Book;
import com.example.book.Model.Category;
import com.example.book.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public String ShowAllCategories(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "category/add";

    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category")Category category ){
            categoryService.saveCategory(category);
            return "redirect:/categories";

    }
    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") Long id, Model model){
        Category editCategory = null;
        for (Category category: categoryService.getAllCategory())
            if(category.getId().equals(id))
                editCategory = category;
        if(editCategory!= null){
            model.addAttribute("category", editCategory);
            return "category/edit";
        }else
            return "not-found!";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id,@ModelAttribute("category") Category category,Model model) {
            categoryService.saveCategory(category);
            return "redirect:/categories";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}

