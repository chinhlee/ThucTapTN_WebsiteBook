package chinh.it.webbook.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="orders_id")
  private long idDH;
  @Column(name="user_id")
  private long idKH;

  @Column(name="total")
  private String tongTien;
  @Column(name="orders_date")
  private String ngayDH;

  @Column(name="status")
  private String trangThai;

  public Orders() {
  }

  public Orders(long idDH, long idKH, String tongTien, String ngayDH, String trangThai) {
    this.idDH = idDH;
    this.idKH = idKH;
    this.tongTien = tongTien;
    this.ngayDH = ngayDH;
    this.trangThai = trangThai;
  }

  public long getIdDH() {
    return idDH;
  }

  public void setIdDH(long idDH) {
    this.idDH = idDH;
  }

  public long getIdKH() {
    return idKH;
  }

  public void setIdKH(long idKH) {
    this.idKH = idKH;
  }

  public String getTongTien() {
    return tongTien;
  }

  public void setTongTien(String tongTien) {
    this.tongTien = tongTien;
  }

  public String getNgayDH() {
    return ngayDH;
  }

  public void setNgayDH(String ngayDH) {
    this.ngayDH = ngayDH;
  }

  public String getTrangThai() {
    return trangThai;
  }

  public void setTrangThai(String trangThai) {
    this.trangThai = trangThai;
  }
}
