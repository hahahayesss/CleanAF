package com.r00t.cleanaf.data.net.mappers;

import com.r00t.cleanaf.data.net.model.ProductNetEntity;
import com.r00t.cleanaf.domain.model.Product;
import com.r00t.cleanaf.domain.util.EntityMapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class NetMapper implements EntityMapper<ProductNetEntity, Product> {

    @Inject
    public NetMapper() {
    }

    @Override
    public Product mapFromEntity(ProductNetEntity productNetEntity) {
        return new Product(
                productNetEntity.getId(),
                productNetEntity.getName(),
                productNetEntity.getDiscount(),
                productNetEntity.getLanguage(),
                productNetEntity.getKitSize(),
                productNetEntity.getPrice(),
                productNetEntity.getCreationDate(),
                productNetEntity.getUpdatedDate()
        );
    }

    @Override
    public ProductNetEntity mapToEntity(Product product) {
        return new ProductNetEntity(
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

    public List<Product> mapFromEntities(List<ProductNetEntity> productCacheEntities) {
        return productCacheEntities.stream()
                .map(this::mapFromEntity).collect(Collectors.toList());
    }

    public List<ProductNetEntity> mapToEntities(List<Product> products) {
        return products.stream()
                .map(this::mapToEntity).collect(Collectors.toList());
    }
}
