package com.anhtm.ordersfood.common;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity<?>, E extends Serializable> extends JpaRepository<T, E> {
}
