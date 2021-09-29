package com.anhtm.ordersfood.service.impl;

import com.anhtm.ordersfood.converter.CategoriesConverter;
import com.anhtm.ordersfood.converter.ProductConverter;
import com.anhtm.ordersfood.dto.ProductDto;
import com.anhtm.ordersfood.entity.Product;
import com.anhtm.ordersfood.repository.CategoriesRepository;
import com.anhtm.ordersfood.repository.ProductRepository;
import com.anhtm.ordersfood.service.ProductService;
import com.anhtm.ordersfood.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private CategoriesConverter categoriesConverter;

    @Override
    public ResponseEntity <Object> save (List <ProductDto> dtos) {
        if (dtos == null || dtos.size() == 0) {
            return ResponseUtils.response(null, "Object null", HttpStatus.BAD_REQUEST);
        }
        List <Product> products = new ArrayList <Product>(dtos.size());
        dtos.forEach(productDto -> {
            categoriesRepository.findById(productDto.getCategoriesId()).ifPresent(
                    categories -> productDto.setCategories(categoriesConverter.entityToDto(categories)));
            products.add(productConverter.dtoToEntity(productDto));
        });

        productRepository.saveAll(products);
        return ResponseUtils.response(dtos, "Completed", HttpStatus.OK);
    }

    @Override
    public ResponseEntity <Object> update (ProductDto productDto) {
        return null;
    }

    @Override
    public ResponseEntity <Object> delete (Integer id) {
        Optional <Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            return ResponseUtils.response(null, "Object not found", HttpStatus.BAD_REQUEST);
        }

        Product product = optionalProduct.get();
        product.setActive(false);
        productRepository.save(product);

        return ResponseUtils.response(productConverter.entityToDto(product), "Completed", HttpStatus.OK);
    }

    @Override
    public ResponseEntity <Object> deleteAndFlush (Integer id) {
        if (!productRepository.findById(id).isPresent()) {
            return ResponseUtils.response(null, "Object not found", HttpStatus.BAD_REQUEST);
        }
        productRepository.deleteById(id);

        return ResponseUtils.response(id, "Completed", HttpStatus.OK);
    }

    @Override
    public ResponseEntity <Object> getAll () {
        List<ProductDto> dtos = new ArrayList <>();
        productRepository.findAll().forEach(product -> {
            dtos.add(this.productConverter.entityToDto(product));
        });

        return ResponseUtils.response(dtos, "Completed", HttpStatus.OK);
    }
}
