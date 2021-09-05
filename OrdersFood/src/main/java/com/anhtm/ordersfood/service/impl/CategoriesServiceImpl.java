package com.anhtm.ordersfood.service.impl;

import com.anhtm.ordersfood.converter.CategoriesConverter;
import com.anhtm.ordersfood.dto.CategoriesDto;
import com.anhtm.ordersfood.entity.Categories;
import com.anhtm.ordersfood.repository.CategoriesRepository;
import com.anhtm.ordersfood.service.CategoriesService;
import com.anhtm.ordersfood.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private CategoriesConverter categoriesConverter;

    @Override
    public ResponseEntity <Object> save (CategoriesDto dto) {
        if (dto == null) {
            return ResponseUtils.response(null, "Object null", HttpStatus.BAD_REQUEST);
        }
        Categories categories = categoriesConverter.dtoToEntity(dto);

        categoriesRepository.save(categories);

        return ResponseUtils.response(dto, "Completed", HttpStatus.OK);
    }

    @Override
    public ResponseEntity <Object> update (CategoriesDto categoriesDto) {
        if (categoriesDto == null) {
            return ResponseUtils.response(null, "Object null", HttpStatus.BAD_REQUEST);
        }

        if (!categoriesRepository.findById(categoriesDto.getId()).isPresent()) {
            return ResponseUtils.response(categoriesDto, "Not found id", HttpStatus.BAD_REQUEST);
        }

        categoriesRepository.save(categoriesConverter.dtoToEntity(categoriesDto));

        return ResponseUtils.response(categoriesDto, "Completed", HttpStatus.OK);
    }

    @Override
    public ResponseEntity <Object> delete (Integer id) {
        Optional <Categories> optional = categoriesRepository.findById(id);

        if (!optional.isPresent()) {
            return ResponseUtils.response(id, "Not found id", HttpStatus.BAD_REQUEST);
        }
        Categories categories = optional.get();
        categories.setActive(false);
        categoriesRepository.save(categories);

        return ResponseUtils.response(categoriesConverter.entityToDto(categories), "Completed",
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity <Object> deleteAndFlush (Integer id) {
        Optional <Categories> optional = categoriesRepository.findById(id);

        if (!optional.isPresent()) {
            return ResponseUtils.response(id, "Not found id", HttpStatus.BAD_REQUEST);
        }

        categoriesRepository.deleteById(id);

        return ResponseUtils.response(id, "Completed", HttpStatus.OK);
    }
}
