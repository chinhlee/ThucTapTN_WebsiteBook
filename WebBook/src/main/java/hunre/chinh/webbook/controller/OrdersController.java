package hunre.chinh.webbook.controller;

import hunre.chinh.webbook.entity.Orders;
import hunre.chinh.webbook.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrdersController {
  private final OrdersService service;

  public OrdersController(OrdersService service) {
    this.service = service;
  }

//  @GetMapping("/orders_register")
//  public String ordersRegister() {
//    return "ordersRegister";
//  }

  @GetMapping("/available_orders")
  public ModelAndView getAllOrders() {
    List<Orders> list = service.getAllOrders();
    return new ModelAndView("ordersList", "orders", list);
  }

  @PostMapping("/save_orders")
  public String addOrders(@ModelAttribute Orders o) {
    service.saveOrders(o);
    return "redirect:/available_orders";
  }

  @RequestMapping("/editOrders/{idDH}")
  public String editOrders(@PathVariable("idDM") long idDH, Model model) {
    Orders o = service.getOrdersById(idDH);
    model.addAttribute("orders", o);
    return "ordersEdit";
  }

  @RequestMapping("/deleteOrders/{idDH}")
  public String deleteOrders(@PathVariable("idDH") long idDH) {
    service.deleteById(idDH);
    return "redirect:/available_orders";
  }
}
