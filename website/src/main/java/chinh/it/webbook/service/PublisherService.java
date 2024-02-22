package chinh.it.webbook.service;


import chinh.it.webbook.entity.Publisher;
import chinh.it.webbook.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
  private final PublisherRepository pRepo;

  public PublisherService(PublisherRepository pRepo) {
    this.pRepo = pRepo;
  }

  public void savePublisher(Publisher p) {
    pRepo.save(p);
  }

  public List<Publisher> getAllPublisher() {
    return pRepo.findAll();
  }

  public Publisher getPublisherById(long idNXB) {
    return pRepo.findById(idNXB).get();
  }

  public void deleteById(long idNXB) {
    pRepo.deleteById(idNXB);
  }
}
