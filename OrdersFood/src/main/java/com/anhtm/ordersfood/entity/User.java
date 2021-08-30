package com.anhtm.ordersfood.entity;

import com.anhtm.ordersfood.common.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Table(name = "tbl_user")
@Entity
public class User extends BaseEntity<Serializable> {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 200)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false, unique = true, length = 200)
    private String phone;

    @Column(name = "username", nullable = false, unique = true, length = 200)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
}
