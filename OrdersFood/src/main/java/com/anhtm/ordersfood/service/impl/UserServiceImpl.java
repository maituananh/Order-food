package com.anhtm.ordersfood.service.impl;

import com.anhtm.ordersfood.converter.UserConverter;
import com.anhtm.ordersfood.dto.LogAppDto;
import com.anhtm.ordersfood.dto.UserDto;
import com.anhtm.ordersfood.entity.User;
import com.anhtm.ordersfood.repository.UserRepository;
import com.anhtm.ordersfood.service.UserService;
import com.anhtm.ordersfood.utils.RegexUtils;
import com.anhtm.ordersfood.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        ResponseEntity <Object> res = this.validEmail(dto) != null ? this.validEmail(dto) :
                this.validNumPhone(dto);
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
        ResponseEntity <Object> res = this.validEmail(dto) != null ? this.validEmail(dto) :
                this.validNumPhone(dto);
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
        Optional <User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActive(false);
            return ResponseUtils.response(userConverter.entityToDto(userRepository.save(user)),
                    "Completed", HttpStatus.OK);
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
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return ResponseUtils.response(id, "Completed", HttpStatus.OK);
        }
        return ResponseUtils.response(id, "ID Not Found", HttpStatus.NOT_FOUND);
    }

    private ResponseEntity <Object> validEmail (UserDto dto) {
        if (!RegexUtils.validateEmail(dto.getEmail())) {
            return ResponseUtils.response(dto, "Email Invalid", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByEmailIgnoreCase(dto.getEmail());
        if (user != null && !user.getId().equals(dto.getId())) {
            return ResponseUtils.response(dto, "Duplicate Email", HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    private ResponseEntity <Object> validNumPhone (UserDto dto) {
        if (dto.getPhone().length() != 10) {
            return ResponseUtils.response(dto, "Number Phone Invalid", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByPhone(dto.getPhone());
        if (user != null && !user.getId().equals(dto.getId())) {
            return ResponseUtils.response(dto, "Duplicate Number Phone", HttpStatus.BAD_REQUEST);
        }
        return null;
    }

//    private ResponseEntity <Object> validPassword (UserDto dto) {
//        if (dto.getPassword().length() < 11 && dto.getPassword().length() > 8) {
//            return ResponseUtils.response(dto, "Invalid Password, password length > 8 and < 11",
//                    HttpStatus.BAD_REQUEST);
//        }
//        return null;
//    }

    @Override
    public ResponseEntity <Object> findUser (LogAppDto dto) {
        if (dto == null || dto.getUsername() == null || dto.getPassword() == null) {
            return ResponseUtils.response(dto, "username or password is empty",
                    HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByUsername(dto.getUsername());

        if (user == null || !passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return ResponseUtils.response(dto, "Invalid username or password",
                    HttpStatus.BAD_REQUEST);
        }

        return ResponseUtils.response(userConverter.entityToDto(user), "Completed",
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> findAllUser() {
        List<UserDto> uList = new ArrayList<UserDto>((int) userRepository.count());
        userRepository.findAll().stream().forEach(user -> {
            uList.add(userConverter.entityToDto(user));
        });

        return ResponseUtils.response(uList, "Completed", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> find(Integer id) {
        UserDto dto = userConverter.entityToDto(userRepository.findById(id).get());
        return ResponseUtils.response(dto, "Completed", HttpStatus.OK);
    }
}
