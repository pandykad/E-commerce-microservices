package com.pair.productservice.service;

import com.pair.productservice.dto.ProductRequest;
import com.pair.productservice.dto.ProductResponse;
import com.pair.productservice.model.Product;
import com.pair.productservice.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//         4 9 11 4 5 = 33


@Service
@RequiredArgsConstructor //makes the constructors for product repository
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();


        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productsProductResponse = new ArrayList<>();
        for(Product product : products){
            productsProductResponse.add(maptoProductResponse(product));
        }

        return productsProductResponse;
    }

    public ProductResponse maptoProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
