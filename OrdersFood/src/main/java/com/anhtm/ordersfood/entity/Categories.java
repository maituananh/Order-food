package com.anhtm.ordersfood.entity;

import com.anhtm.ordersfood.common.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Table(name = "tbl_categories")
@Entity
public class Categories extends BaseEntity <Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Product.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch =
            FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    @Fetch(value= FetchMode.SELECT)
    private Set <Product> products;
}
