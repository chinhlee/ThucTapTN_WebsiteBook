package chinh.it.webbook.service;


import chinh.it.webbook.entity.Author;
import chinh.it.webbook.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
  private final AuthorRepository aRepo;

  public AuthorService(AuthorRepository aRepo) {
    this.aRepo = aRepo;
  }

  public void saveAuthor(Author a) {
    aRepo.save(a);
  }

  public List<Author> getAllAuthor() {
    return aRepo.findAll();
  }

  public Author getAuthorById(long idTG) {
    return aRepo.findById(idTG).get();
  }

  public void deleteById(long idTG) {
    aRepo.deleteById(idTG);
  }
}
