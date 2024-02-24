package hunre.chinh.webbook.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="publisher_id")
  private long idNXB;
  @Column(name="publisher_name")
  private String tenNXB;
  @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
  private List<Books> books;

  public Publisher() {
  }

  public Publisher(long idNXB, String tenNXB) {
    this.idNXB = idNXB;
    this.tenNXB = tenNXB;
  }

  public long getIdNXB() {
    return idNXB;
  }

  public void setIdNXB(long idNXB) {
    this.idNXB = idNXB;
  }

  public String getTenNXB() {
    return tenNXB;
  }

  public void setTenNXB(String tenNXB) {
    this.tenNXB = tenNXB;
  }
}
