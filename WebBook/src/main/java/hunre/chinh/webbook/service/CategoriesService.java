package hunre.chinh.webbook.service;

import hunre.chinh.webbook.entity.Categories;
import hunre.chinh.webbook.repository.CategoriesRepository;
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
