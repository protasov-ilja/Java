package com.mycompany.app.supermarket.model.processors;

import com.mycompany.app.product.Product;
import com.mycompany.app.supermarket.model.generators.ProductsGenerator;
import javafx.util.Pair;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductProcessorTest {

	@Test
	public void testProductsProcessor() {
		try {
			ProductsGenerator productsGenerator = new ProductsGenerator(9, 10);
			List<Pair<Product, Float>> tempList = productsGenerator.getListOfProducts();
			ProductProcessor productProcessor = new ProductProcessor(tempList);
			assertEquals(productProcessor.getProducts(), tempList);

			ProductsGenerator productsGenerator2 = new ProductsGenerator(11, 20);
			List<Pair<Product, Float>> tempList2 = productsGenerator2.getListOfProducts();
			productProcessor.addProducts(tempList2);
			for (int i = 0; i < productProcessor.getProducts().size(); ++i) {
				productProcessor.checkProductResidue(i);
			}

			assertTrue(true);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}
}