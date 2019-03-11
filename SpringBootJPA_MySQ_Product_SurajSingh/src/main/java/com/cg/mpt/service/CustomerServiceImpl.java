package com.cg.mpt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mpt.beans.Product;
import com.cg.mpt.repository.ProductRepository;

@Transactional
@Service("service")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	ProductRepository repo;	
	public ProductRepository getRepo() {
		return repo;
	}
	public void setRepo(ProductRepository repo) {
		this.repo = repo;
	}
	@Override
	public Product addProduct(Product product) {
		return repo.addProduct(product);
	}
	@Override
	public Product findProduct(String customerid) {
		return repo.findProduct(customerid);
	}
	@Override
	public Product updateProduct(Product customer) {
		// TODO Auto-generated method stub
		return repo.updateProduct(customer);
	}
	@Override
	public List<Product> getProductList() {
		return repo.getProductList();
	}
	@Override
	public Product removeProduct(String custid) {
		// TODO Auto-generated method stub
		return repo.removeProduct(custid);
	}

}
