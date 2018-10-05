package com.service.dao;

import java.util.List;

import com.service.model.Product;

public interface MyProduct {
	
	public void addProduct(Product p)throws Exception;
	List<Product> products()throws Exception;
	 List<Product> byNameorPrice(String name,int price)throws Exception;
	 void updateProduct(Product p)throws Exception;
	 void deleteProduct(int productid)throws Exception;
	 
	
	

}//end of MyProduct Interface
