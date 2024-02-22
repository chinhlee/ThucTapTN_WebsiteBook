package chinh.it.webbook.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categories_id")
    private long idDM;
    @Column(name="categories_name")
    private String tenDM;
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Books> books;

    public Categories() {
    }

    public Categories(long idDM, String tenDM) {
        this.idDM = idDM;
        this.tenDM = tenDM;
    }

    public long getIdDM() {
        return idDM;
    }

    public void setIdDM(long idDM) {
        this.idDM = idDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }
}
