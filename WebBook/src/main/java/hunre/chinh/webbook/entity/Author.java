package hunre.chinh.webbook.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "author")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "author_id")
  private long idTG;
  @Column(name = "author_name")
  private String tenTG;
  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
  private List<Books> books;

  public Author() {
  }

  public Author(long idTG, String tenTG) {
    this.idTG = idTG;
    this.tenTG = tenTG;
  }

  public long getIdTG() {
    return idTG;
  }

  public void setIdTG(long idTG) {
    this.idTG = idTG;
  }

  public String getTenTG() {
    return tenTG;
  }

  public void setTenTG(String tenTG) {
    this.tenTG = tenTG;
  }
}
