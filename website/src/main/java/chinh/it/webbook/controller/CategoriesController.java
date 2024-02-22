package chinh.it.webbook.controller;

import chinh.it.webbook.entity.Categories;
import chinh.it.webbook.service.CategoriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoriesController {
    private final CategoriesService service;

    public CategoriesController(CategoriesService service) {
        this.service = service;
    }

    @GetMapping("/home")
    public String home() {
        return "home_admin";
    }

    @GetMapping("/categories_register")
    public String categoriesRegister() {
        return "categoriesRegister";
    }

    @GetMapping("/available_categories")
    public ModelAndView getAllCategories() {
        List<Categories> list = service.getAllCategories();
        return new ModelAndView("categoriesList", "categories", list);
    }

    @PostMapping("/save_categories")
    public String addCategories(@ModelAttribute Categories c) {
        service.saveCategories(c);
        return "redirect:/available_categories";
    }

    @RequestMapping("/editCategories/{idDM}")
    public String editCategories(@PathVariable("idDM") long idDM, Model model) {
        Categories c = service.getCategoriesById(idDM);
        model.addAttribute("categories", c);
        return "categoriesEdit";
    }

    @RequestMapping("/deleteCategories/{idDM}")
    public String deleteCategories(@PathVariable("idDM") long idDM) {
        service.deleteById(idDM);
        return "redirect:/available_categories";
    }
}
