package hunre.chinh.webbook.service;

import hunre.chinh.webbook.entity.Orders;
import hunre.chinh.webbook.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
  private final OrdersRepository oRepo;

  public OrdersService(OrdersRepository oRepo) {
    this.oRepo = oRepo;
  }

  public void saveOrders(Orders o) {
    oRepo.save(o);
  }

  public List<Orders> getAllOrders() {
    return oRepo.findAll();
  }

  public Orders getOrdersById(long idDH) {
    return oRepo.findById(idDH).get();
  }

  public void deleteById(long idDH) {
    oRepo.deleteById(idDH);
  }
}
