package hunre.chinh.webbook.controller;

import hunre.chinh.webbook.entity.Publisher;
import hunre.chinh.webbook.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PublisherController {
  private final PublisherService service;

  public PublisherController(PublisherService service) {
    this.service = service;
  }

//  @GetMapping("/home")
//  public String home() {
//    return "home_admin";
//  }

  @GetMapping("/publisher_register")
  public String publisherRegister() {
    return "publisherRegister";
  }

  @GetMapping("/available_publisher")
  public ModelAndView getAllPublisher() {
    List<Publisher> list = service.getAllPublisher();
    return new ModelAndView("publisherList", "publisher", list);
  }

  @PostMapping("/save_publisher")
  public String addPublisher(@ModelAttribute Publisher p) {
    service.savePublisher(p);
    return "redirect:/available_publisher";
  }

  @RequestMapping("/editPublisher/{idNXB}")
  public String editPublisher(@PathVariable("idNXB") long idNXB, Model model) {
    Publisher p = service.getPublisherById(idNXB);
    model.addAttribute("publisher", p);
    return "publisherEdit";
  }

  @RequestMapping("/deletePublisher/{idNXB}")
  public String deletePublisher(@PathVariable("idNXB") long idNXB) {
    service.deleteById(idNXB);
    return "redirect:/available_publisher";
  }
}
