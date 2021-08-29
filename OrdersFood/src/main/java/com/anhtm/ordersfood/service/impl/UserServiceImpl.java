package com.anhtm.ordersfood.service.impl;

import com.anhtm.ordersfood.converter.UserConverter;
import com.anhtm.ordersfood.dto.ResponseHeaderDto;
import com.anhtm.ordersfood.dto.UserDto;
import com.anhtm.ordersfood.entity.User;
import com.anhtm.ordersfood.repository.UserRepository;
import com.anhtm.ordersfood.service.UserService;
import com.anhtm.ordersfood.utils.RegexUtils;
import com.anhtm.ordersfood.utils.ResponseUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type User service.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * The User repository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * The User converter.
     */
    @Autowired
    private UserConverter userConverter;

    /**
     * Save response entity .
     *
     * @param dto the dto
     *
     * @return the response entity
     */
    @Override
    public ResponseEntity <Object> save (UserDto dto) {
        // validate email and phone
        ResponseEntity res = this.validEmail(dto) != null ? this.validEmail(dto) : this.validNumPhone(dto);
        if (res != null) {
            return res;
        }

        User user = userRepository.save(userConverter.dtoToEntity(dto));
        return ResponseUtils.response(userConverter.entityToDto(user), "Completed", HttpStatus.OK);
    }

    /**
     * Update response entity .
     *
     * @param dto the dto
     *
     * @return the response entity
     */
    @Override
    public ResponseEntity <Object> update (UserDto dto) {
        if (!userRepository.findById(dto.getId()).isPresent()) {
            return ResponseUtils.response(dto, "Object not found", HttpStatus.NOT_FOUND);
        }
        // validate email and phone
        ResponseEntity res = this.validEmail(dto) != null ? this.validEmail(dto) : this.validNumPhone(dto);
        if (res != null) {
            return res;
        }
        userRepository.save(userConverter.dtoToEntity(dto));
        return ResponseUtils.response(dto, "Completed", HttpStatus.OK);
    }

    /**
     * Delete response entity .
     *
     * @param id the id
     *
     * @return the response entity
     */
    @Override
    public ResponseEntity <Object> delete (Integer id) {
        User user = userRepository.getOne(id);
        if (user != null) {
            user.setActive(false);
            return ResponseUtils.response(userConverter.entityToDto(userRepository.save(user)), "Completed", HttpStatus.OK);
        }
        return ResponseUtils.response(id, "ID Not Found", HttpStatus.NOT_FOUND);
    }

    /**
     * Delete and flush response entity .
     *
     * @param id the id
     *
     * @return the response entity
     */
    @Override
    public ResponseEntity <Object> deleteAndFlush (Integer id) {
        User user = userRepository.getOne(id);
        if (user != null) {
            userRepository.deleteById(id);
            return ResponseUtils.response(userConverter.entityToDto(user), "Completed", HttpStatus.OK);
        }
        return ResponseUtils.response(id, "ID Not Found", HttpStatus.NOT_FOUND);
    }

    private ResponseEntity validEmail(UserDto dto) {
        if (!RegexUtils.validateEmail(dto.getEmail())) {
            return ResponseUtils.response(dto, "Email Invalid", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByEmailIgnoreCase(dto.getEmail());
        if (user != null && user.getId() != dto.getId()) {
            return ResponseUtils.response(dto, "Duplicate Email", HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    private ResponseEntity validNumPhone(UserDto dto) {
        if (dto.getPhone().length() != 10) {
            return ResponseUtils.response(dto, "Number Phone Invalid", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByPhone(dto.getPhone());
        if (user != null && user.getId() != dto.getId()) {
            return ResponseUtils.response(dto, "Duplicate Number Phone", HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    public User getCurrentUser() {
        return userRepository.findById(1).get();
    }
}
