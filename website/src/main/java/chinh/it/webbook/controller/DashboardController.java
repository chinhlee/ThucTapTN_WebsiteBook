package chinh.it.webbook.controller;

import chinh.it.webbook.entity.Categories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DashboardController {
  @GetMapping("/dashboard.html")
  public String dashboard() {
    return "dashboard"; // Trả về tên của file HTML tương ứng
  }
}
