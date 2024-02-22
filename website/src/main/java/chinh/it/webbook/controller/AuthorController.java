package chinh.it.webbook.controller;

import chinh.it.webbook.entity.Author;
import chinh.it.webbook.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthorController {
  private final AuthorService service;

  public AuthorController(AuthorService service) {
    this.service = service;
  }

//  @GetMapping("/home")
//  public String home() {
//    return "home_admin";
//  }

  @GetMapping("/author_register")
  public String authorRegister() {
    return "authorRegister";
  }

  @GetMapping("/available_author")
  public ModelAndView getAllAuthor() {
    List<Author> list = service.getAllAuthor();
    return new ModelAndView("authorList", "author", list);
  }

  @PostMapping("/save_author")
  public String addCategories(@ModelAttribute Author a) {
    service.saveAuthor(a);
    return "redirect:/available_author";
  }

  @RequestMapping("/editAuthor/{idTG}")
  public String editAuthor(@PathVariable("idTG") long idTG, Model model) {
    Author a = service.getAuthorById(idTG);
    model.addAttribute("author", a);
    return "authorEdit";
  }

  @RequestMapping("/deleteAuthor/{idTG}")
  public String deleteAuthor(@PathVariable("idTG") long idTG) {
    service.deleteById(idTG);
    return "redirect:/available_author";
  }
}
