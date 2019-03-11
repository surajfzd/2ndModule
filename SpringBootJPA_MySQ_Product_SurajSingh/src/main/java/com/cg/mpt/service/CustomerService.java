package com.cg.mpt.service;

import java.util.List;
import com.cg.mpt.beans.Product;

public interface CustomerService {


	public Product addProduct(Product Product);
	public Product findProduct(String customerid);
	public Product updateProduct(Product customer);
	public List<Product> getProductList();
	public Product removeProduct(String custid);
}
