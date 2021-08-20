package com.anhtm.ordersfood.entity;

import com.anhtm.ordersfood.common.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Table(name = "tbl_cart")
@Entity
public class Cart extends BaseEntity<Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CartProduct> cartProducts = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "quantity")
    private Integer quantity;
}
