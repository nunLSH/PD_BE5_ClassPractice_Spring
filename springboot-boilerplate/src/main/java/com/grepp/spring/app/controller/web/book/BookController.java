package com.grepp.spring.app.controller.web.book;

import com.grepp.spring.app.controller.web.book.payload.BookRegistRequest;
import com.grepp.spring.app.model.book.BookService;
import com.grepp.spring.app.model.book.code.Category;
import com.grepp.spring.app.model.book.dto.BookDto;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {
    
    private final BookService bookService;
    
    @GetMapping("regist")
    public String regist(BookRegistRequest form, Model model){
        model.addAttribute("category", Category.values());
        return "book/book-regist";
    }
    
    @PostMapping("regist")
    public String regist(@Valid BookRegistRequest form, BindingResult bindingResult
                                ,Model model){
        
        if(bindingResult.hasErrors()){
            model.addAttribute("category", Category.values());
            return "book/book-regist";
        }
        
        bookService.registBook(form.getThumbnail(), form.toDto());
        return "redirect:/";
    }
    
    @GetMapping("list")
    public String list(Pageable pageable, Model model){
        List<BookDto> bookDtos = bookService.findPaged(pageable);
        model.addAttribute("books", bookDtos);
        return "book/book-list";
    }
}
