package com.cg.mpt.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.mpt.beans.Product;

@Repository("repo")
public class ProductRepositoryImpl implements ProductRepository {

	@PersistenceContext
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Product addProduct(Product product) {
		entityManager.persist(product);
		entityManager.flush();
		return product;
	}

	@Override
	public Product findProduct(String customerid) {
		Product customer = entityManager.find(Product.class, customerid);
		if (customer == null)
			return null;
		customer.setId(customerid);
		return customer;
	}

	@Override
	public Product updateProduct(Product product) {
		entityManager.merge(product);
		entityManager.flush();
		return product;
	}

	@Override
	public List<Product> getProductList() {
		TypedQuery<Product> query = entityManager.createQuery("select product from Product product ", Product.class);

		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public Product removeProduct(String proid) {
		Product product = entityManager.find(Product.class, proid);
		entityManager.remove(product);
		entityManager.flush();
		return product;
	}

	// @Override
	// public Product addCustomer(Product customer) {
	//
	// entityManager.persist(customer);
	// entityManager.flush();
	// return customer;
	// }
	// @Override
	// public Product findCustomer(int customerid) {
	// Product customer=
	// entityManager.find(Product.class, customerid);
	// if(customer==null)
	// return null;
	// customer.setCustomerId(customerid);
	// return customer;
	// }
	// @Override
	// public Product updateCustomer(Product customer) {
	// entityManager.merge(customer);
	// entityManager.flush();
	// return customer;
	// }
	// @Override
	// public List<Product> getCustomerList() {
	// TypedQuery<Product> query=
	// entityManager.createQuery
	// ("select customer from Customer customer ", Product.class);
	//
	// List<Product> list= query.getResultList();
	// return list;
	// }
	// @Override
	// public Product removeCustomer(int custid) {
	// Product customer= entityManager.find(Product.class, custid);
	// entityManager.remove(customer);
	// entityManager.flush();
	// return customer;
	// }

}
