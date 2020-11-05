package com.r00t.cleanaf.data.cache.mappers;

import com.r00t.cleanaf.data.cache.model.ProductCacheEntity;
import com.r00t.cleanaf.domain.model.Product;
import com.r00t.cleanaf.domain.util.EntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class CacheMapper implements EntityMapper<ProductCacheEntity, Product> {

    @Inject
    public CacheMapper() {
    }

    @Override
    public Product mapFromEntity(ProductCacheEntity productCacheEntity) {
        return new Product(
                productCacheEntity.getId(),
                productCacheEntity.getName(),
                productCacheEntity.getDiscount(),
                productCacheEntity.getLanguage(),
                productCacheEntity.getKitSize(),
                productCacheEntity.getPrice(),
                productCacheEntity.getCreationDate(),
                productCacheEntity.getUpdatedDate()
        );
    }

    @Override
    public ProductCacheEntity mapToEntity(Product product) {
        return new ProductCacheEntity(
                product.getId(),
                product.getName(),
                product.getDiscount(),
                product.getLanguage(),
                product.getKitSize(),
                product.getPrice(),
                product.getCreationDate(),
                product.getUpdatedDate()
        );
    }

    public List<Product> mapFromEntities(List<ProductCacheEntity> productCacheEntities) {
        return productCacheEntities.stream()
                .map(this::mapFromEntity).collect(Collectors.toList());
    }

    public List<ProductCacheEntity> mapToEntities(List<Product> products) {
        return products.stream()
                .map(this::mapToEntity).collect(Collectors.toList());
    }
}
