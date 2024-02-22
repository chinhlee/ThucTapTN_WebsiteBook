package chinh.it.webbook.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "books")
public class Books {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id")
  private long idSach;
  @Lob
  @Column(name = "book_image")
  private byte[] image;
  @Column(name = "book_name")
  private String tenSach;
  @Column(name = "book_price")
  private double giaSach;
  @Column(name = "book_quantity")
  private int soLuong;
  @Column(name = "book_description")
  private String moTa;
  @Column(name = "book_total")
  private int soTrang;
  @Column(name = "book_cover")
  private String loaiBia;
  @Column(name = "book_size")
  private String kichThuoc;
  @Column(name = "book_date")
  private String ngayXB;
  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;
  @ManyToOne
  @JoinColumn(name = "categories_id")
  private Categories categories;
  @ManyToOne
  @JoinColumn(name = "publisher_id")
  private Publisher publisher;

  public Books() {
  }

  public Books(long idSach, byte[] image, String tenSach, double giaSach, int soLuong, String moTa, int soTrang, String loaiBia, String kichThuoc, String ngayXB, Author author, Categories categories, Publisher publisher) {
    this.idSach = idSach;
    this.image = image;
    this.tenSach = tenSach;
    this.giaSach = giaSach;
    this.soLuong = soLuong;
    this.moTa = moTa;
    this.soTrang = soTrang;
    this.loaiBia = loaiBia;
    this.kichThuoc = kichThuoc;
    this.ngayXB = ngayXB;
    this.author = author;
    this.categories = categories;
    this.publisher = publisher;
  }

  public long getIdSach() {
    return idSach;
  }

  public void setIdSach(long idSach) {
    this.idSach = idSach;
  }

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public String getTenSach() {
    return tenSach;
  }

  public void setTenSach(String tenSach) {
    this.tenSach = tenSach;
  }

  public double getGiaSach() {
    return giaSach;
  }

  public void setGiaSach(double giaSach) {
    this.giaSach = giaSach;
  }

  public int getSoLuong() {
    return soLuong;
  }

  public void setSoLuong(int soLuong) {
    this.soLuong = soLuong;
  }

  public String getMoTa() {
    return moTa;
  }

  public void setMoTa(String moTa) {
    this.moTa = moTa;
  }

  public int getSoTrang() {
    return soTrang;
  }

  public void setSoTrang(int soTrang) {
    this.soTrang = soTrang;
  }

  public String getLoaiBia() {
    return loaiBia;
  }

  public void setLoaiBia(String loaiBia) {
    this.loaiBia = loaiBia;
  }

  public String getKichThuoc() {
    return kichThuoc;
  }

  public void setKichThuoc(String kichThuoc) {
    this.kichThuoc = kichThuoc;
  }

  public String getNgayXB() {
    return ngayXB;
  }

  public void setNgayXB(String ngayXB) {
    this.ngayXB = ngayXB;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Categories getCategories() {
    return categories;
  }

  public void setCategories(Categories categories) {
    this.categories = categories;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }
}
