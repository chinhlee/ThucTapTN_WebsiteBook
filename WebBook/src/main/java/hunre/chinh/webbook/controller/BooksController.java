package hunre.chinh.webbook.controller;


import hunre.chinh.webbook.entity.Author;
import hunre.chinh.webbook.entity.Books;
import hunre.chinh.webbook.entity.Categories;
import hunre.chinh.webbook.entity.Publisher;
import hunre.chinh.webbook.service.AuthorService;
import hunre.chinh.webbook.service.BooksService;
import hunre.chinh.webbook.service.CategoriesService;
import hunre.chinh.webbook.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BooksController {
  private final BooksService service;
  private final CategoriesService categoriesService;
  private final AuthorService authorService;
  private final PublisherService publisherService;

  public BooksController(BooksService service, CategoriesService categoriesService,AuthorService authorService,PublisherService publisherService ) {
    this.service = service;
    this.categoriesService = categoriesService;
    this.authorService = authorService;
    this.publisherService = publisherService;
  }

  @GetMapping("/books_register")
  public String booksRegister( Model model) {
    // Lấy danh sách các danh mục từ cơ sở dữ liệu
    List<Categories> categories = categoriesService.getAllCategories();
    List<Author> author = authorService.getAllAuthor();
    List<Publisher> publisher = publisherService.getAllPublisher();
    // Đưa danh sách danh mục vào model để sử dụng trong trang booksRegister
    model.addAttribute("categories", categories);
    model.addAttribute("author", author);
    model.addAttribute("publisher", publisher);
    // Truyền danh sách mã danh mục vào form thêm sách
    model.addAttribute("book", new Books());
    return "booksRegister";
  }

  @GetMapping("/available_books")
  public ModelAndView getAllBooks() {
    List<Books> list = service.getAllBooks();
    return new ModelAndView("booksList", "books", list);
  }

  @PostMapping("/save_books")
  public String addBooks(@ModelAttribute Books b) {
    service.saveBooks(b);
    return "redirect:/available_books";
  }

  @RequestMapping("/editBooks/{idSach}")
  public String editBooks(@PathVariable("idSach") long idSach, Model model) {
    Books b = service.getBooksById(idSach);
    // Lấy danh sách các danh mục từ cơ sở dữ liệu
    List<Categories> categories = categoriesService.getAllCategories();
    List<Author> author = authorService.getAllAuthor();
    List<Publisher> publisher = publisherService.getAllPublisher();
    // Đưa danh sách danh mục vào model để sử dụng trong trang booksRegister
    model.addAttribute("categories", categories);
    model.addAttribute("author", author);
    model.addAttribute("publisher", publisher);
    model.addAttribute("books", b);
    return "booksEdit";
  }

  @RequestMapping("/deleteBooks/{idSach}")
  public String deleteBooks(@PathVariable("idSach") long idSach) {
    service.deleteById(idSach);
    return "redirect:/available_books";
  }

  @PostMapping("/upload")
  public String uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("idSach") long idSach) {
    service.saveImage(file, idSach);
    return "booksRegister";
  }
}
