package hunre.chinh.webbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
  @GetMapping("/dashboard.html")
  public String dashboard() {
    return "dashboard"; // Trả về tên của file HTML tương ứng
  }
}
