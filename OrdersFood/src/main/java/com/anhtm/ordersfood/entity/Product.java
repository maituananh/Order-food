package com.anhtm.ordersfood.entity;

import com.anhtm.ordersfood.common.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
    private Integer price;

    @Column(name = "main_photo")
    private Integer mainPhoto;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categories = new Categories();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user = new User();

    @Column(name = "active")
    private boolean active;
}
