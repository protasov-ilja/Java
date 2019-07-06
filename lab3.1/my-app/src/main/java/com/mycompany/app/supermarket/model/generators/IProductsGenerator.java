package com.mycompany.app.supermarket.model.generators;

import com.mycompany.app.product.Product;
import javafx.util.Pair;

import java.util.List;

public interface IProductsGenerator {
	List<Pair<Product, Float>> getListOfProducts();
}
