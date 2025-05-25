package com.chama.Chama.services;

import com.chama.Chama.dtos.ProductDto;
import com.chama.Chama.entities.Product;
import com.chama.Chama.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> allProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product productById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow();
    }

    public Page<Product> productByName(String name, Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public Page<Product> productByCategory(String category, Pageable pageable) {
        return productRepository.findByCategoryContainingIgnoreCase(category, pageable);
    }

    public Product addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow();

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());

        return product;
    }

    public Boolean deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return true;
    }
}
