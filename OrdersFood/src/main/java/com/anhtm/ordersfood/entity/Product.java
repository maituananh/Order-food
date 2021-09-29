package com.anhtm.ordersfood.entity;

import com.anhtm.ordersfood.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "tbl_product")
@Entity
public class Product extends BaseEntity <Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "quantity")
    private Integer quantity;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = DataSource.class)
//    @JoinColumn(name = "main_photo")
//    private DataSource mainPhoto;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categories;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<DataSource> dataSourceProduct = new HashSet<>();

//    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    private Set <CartProduct> cartProducts;
}
