package com.anhtm.ordersfood.repository;

import org.springframework.stereotype.Repository;

import com.anhtm.ordersfood.common.BaseRepository;
import com.anhtm.ordersfood.entity.User;

@Repository
public interface UserRepository extends BaseRepository<User, Integer> {
  
}
