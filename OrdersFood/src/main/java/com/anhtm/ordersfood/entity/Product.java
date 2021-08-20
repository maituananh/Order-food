package com.anhtm.ordersfood.entity;

import com.anhtm.ordersfood.common.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "main_photo")
    private DataSource mainPhoto;

    @ManyToOne
    @JoinColumn(name = "categories_id", nullable = false)
    private Categories categories;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "active")
    private boolean active;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DataSource> dataSourceProduct = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CartProduct> cartProducts = new HashSet<>();
}
