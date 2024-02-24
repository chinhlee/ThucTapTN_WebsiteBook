package hunre.chinh.webbook.service;


import hunre.chinh.webbook.entity.Books;
import hunre.chinh.webbook.repository.BooksRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BooksService {
  private final BooksRepository bRepo;

  public BooksService(BooksRepository bRepo) {
    this.bRepo = bRepo;
  }

  public void saveBooks(Books b) {
    bRepo.save(b);
  }

  public List<Books> getAllBooks() {
    return bRepo.findAll();
  }

  public Books getBooksById(long idSach) {
    return bRepo.findById(idSach).get();
  }

  public void deleteById(long idSach) {
    bRepo.deleteById(idSach);
  }

  public void saveImage(MultipartFile file, long idSach) {
    try {
      Books books = new Books();
      books.setImage(file.getBytes());
      bRepo.save(books);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
