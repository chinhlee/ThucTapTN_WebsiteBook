package hunre.chinh.webbook.service;

import hunre.chinh.webbook.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import hunre.chinh.webbook.entity.Author;

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
