package com.anhtm.ordersfood.entity;

import com.anhtm.ordersfood.common.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@Table(name = "tbl_product")
@Entity
public class Product extends BaseEntity<Serializable> {
  
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

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = DataSource.class)
//    @JoinColumn(name = "main_photo")
//    private DataSource mainPhoto;

    @ManyToOne
    @JoinColumn(name = "categories_id", nullable = false)
    private Categories categories;

    @Column(name = "quantity")
    private Integer quantity;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<DataSource> dataSourceProduct = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<CartProduct> cartProducts;
}
