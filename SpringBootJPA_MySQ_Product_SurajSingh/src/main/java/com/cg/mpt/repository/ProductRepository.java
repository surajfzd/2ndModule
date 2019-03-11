package com.cg.mpt.repository;

import java.util.List;
import com.cg.mpt.beans.Product;

public interface ProductRepository {

	public Product addProduct(Product product);
	public Product findProduct(String id);
	public Product updateProduct(Product product);
	public List<Product> getProductList();
    public Product removeProduct(String proid);
}
