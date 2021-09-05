package com.anhtm.ordersfood.repository;

import com.anhtm.ordersfood.common.BaseRepository;
import com.anhtm.ordersfood.entity.User;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

    /**
     * Find by email ignore case user.
     *
     * @param email the email
     *
     * @return the user
     */
    User findByEmailIgnoreCase(String email);

    User findByPhone(String phone);

    User findByUsername(String username);
}
