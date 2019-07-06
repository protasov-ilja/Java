package com.company.supermarket.model.generators;

import com.company.product.Product;
import javafx.util.Pair;

import java.util.List;

public interface IProductsGenerator {
	List<Pair<Product, Float>> getListOfProducts();
}
