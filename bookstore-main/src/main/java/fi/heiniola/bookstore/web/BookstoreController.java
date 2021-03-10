package fi.heiniola.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fi.heiniola.bookstore.domain.Book;
import fi.heiniola.bookstore.domain.BookRepository;
import fi.heiniola.bookstore.domain.CategoryRepository;

@Controller

public class BookstoreController {
	@Autowired
 
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;


@RequestMapping(value="/login")
public String login() {
	return "login";
}    

	@RequestMapping(value= {"/", "/booklist"})
	public String bookList(Model model) {
	model.addAttribute("books", repository.findAll());
	return "booklist";
}
	@RequestMapping(value = "/addbook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
  
	}
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	model.addAttribute("book", repository.findById(bookId));
    	model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }
	
}