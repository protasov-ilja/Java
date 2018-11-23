package com.company.supermarket.model.processors;

import com.company.product.Products;

import java.util.List;

public interface IProductProcessor {
	void addProducts(List<Products> products);

	List<Products> getProducts();

	void checkProductResidue(int productIndex);
}
