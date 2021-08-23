package com.anhtm.ordersfood.service.impl;

import com.anhtm.ordersfood.converter.UserConverter;
import com.anhtm.ordersfood.dto.ResponseHeaderDto;
import com.anhtm.ordersfood.dto.UserDto;
import com.anhtm.ordersfood.entity.User;
import com.anhtm.ordersfood.repository.UserRepository;
import com.anhtm.ordersfood.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * The User repository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * The Model mapper.
     */
    @Autowired
    private ModelMapper modelMapper;

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
        ResponseEntity <Object> result;
        User user = null;
        user = userRepository.findByEmailIgnoreCase(dto.getEmail());

        if (user == null) {
            userRepository.save(userConverter.dtoToEntity(dto));
            result = new ResponseEntity <Object>(userConverter.entityToDto(userRepository.getOne(
                    user.getId())), HttpStatus.OK);
        } else {
            result = new ResponseEntity <Object>(new ResponseHeaderDto(null, HttpStatus.BAD_REQUEST,
                    "Duplicate Email"), HttpStatus.BAD_REQUEST);
        }
        return result;
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
        ResponseEntity <Object> result;
        if (userRepository.getOne(dto.getId()) != null) {
            User user = modelMapper.map(dto, User.class);
            userRepository.save(user);
            result = new ResponseEntity <Object>(dto, HttpStatus.OK);
        } else {
            result = new ResponseEntity <Object>(dto, HttpStatus.NOT_FOUND);
        }
        return result;
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
        UserDto userDto = null;
        if (user != null) {
            user.setActive(false);
            userRepository.save(user);
            userDto = modelMapper.map(user, UserDto.class);
            return new ResponseEntity <Object>(userDto, HttpStatus.OK);
        }
        return new ResponseEntity <Object>(userDto, HttpStatus.NOT_FOUND);
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
        UserDto userDto = modelMapper.map(user, UserDto.class);
        if (user != null) {
            userRepository.deleteById(id);
            return new ResponseEntity <Object>(userDto, HttpStatus.OK);
        }
        return new ResponseEntity <Object>(userDto, HttpStatus.NOT_FOUND);
    }
}
