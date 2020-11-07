package com.r00t.cleanaf.presentation.view;

import com.r00t.cleanaf.domain.model.Product;

import java.util.Collection;

public interface ProductListView extends LoadDataView {

    void renderProductList(Collection<Product> productCollection);
}
