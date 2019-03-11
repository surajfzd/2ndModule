package com.cg.mpt.SpringBootJPAIntegrationvansh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.mpt.beans.Product;
import com.cg.mpt.service.CustomerService;


@RestController
public class MyRestController {
	
	 @Autowired
	CustomerService service;
	
	
	public CustomerService getService() {
		return service;
	}


	public void setService(CustomerService service) {
		this.service = service;
	}


	@RequestMapping(value="/addProduct",consumes="application/json",
			method=RequestMethod.POST,produces="application/json")
	public Product addCustomer(@RequestBody Product customer)
	{
		
		customer= service.addProduct(customer);
		return customer;
	}
	
	@RequestMapping(value="/findProduct/{customerId}",produces="application/json")
	public Product findCustomer(@PathVariable String customerId)
	{
		Product product=service.findProduct(customerId);
		return product;
	}

	@RequestMapping(value="/updateProduct/{customerId}",consumes="application/json",
			produces="application/json",method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product)
	{
		
		product=service.updateProduct(product);
		return product;
	}
	
	
	@RequestMapping(value="/removeProduct/{customerId}",consumes="application/json",
			method=RequestMethod.POST,produces="application/json")
	public Product removeCustomer(@PathVariable String customerId)
	{
		Product product=service.removeProduct(customerId);
		return product;
	}
	
	@RequestMapping(value="getProductList",produces="application/json")
	public List<Product> getProductList()
	{
		List<Product> list =service.getProductList();
		return list;
	}
	
	
	
}






