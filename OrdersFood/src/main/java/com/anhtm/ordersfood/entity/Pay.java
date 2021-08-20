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
@Table(name = "tbl_pay")
@Entity
public class Pay extends BaseEntity<Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "pay", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CartProduct> cartProducts = new HashSet<>();
}
