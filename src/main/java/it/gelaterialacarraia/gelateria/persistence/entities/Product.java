package it.gelaterialacarraia.gelateria.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_name", nullable = false)
    private String name;
    @Column (name = "is_dairy_free", nullable = false, columnDefinition = "BOOLEAN NOT NULL DEFAULT false")
    private boolean isDairyFree;
    @Column (name = "is_nut_free", nullable = false, columnDefinition = "BOOLEAN NOT NULL DEFAULT false")
    private boolean isNutFree;
    @Column (name = "is_vegan", nullable = false, columnDefinition = "BOOLEAN NOT NULL DEFAULT false")
    private boolean isVegan;
    @Column (name= "cover", columnDefinition = "MEDIUMBLOB")
    @Lob
    private byte[] cover;

    @ManyToOne
    @JoinColumn(name = "id_supplier", nullable = false)
    private Supplier supplier;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDairyFree() {
        return isDairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        isDairyFree = dairyFree;
    }

    public boolean isNutFree() {
        return isNutFree;
    }

    public void setNutFree(boolean nutFree) {
        isNutFree = nutFree;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
