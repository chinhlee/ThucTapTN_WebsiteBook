package chinh.it.webbook.service;

import chinh.it.webbook.entity.Categories;
import chinh.it.webbook.repositories.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
  private final CategoriesRepository cRepo;

  public CategoriesService(CategoriesRepository cRepo) {
    this.cRepo = cRepo;
  }

  public void saveCategories(Categories c) {
    cRepo.save(c);
  }

  public List<Categories> getAllCategories() {
    return cRepo.findAll();
  }

  public Categories getCategoriesById(long idDM) {
    return cRepo.findById(idDM).get();
  }

  public void deleteById(long idDM) {
    cRepo.deleteById(idDM);
  }
}
