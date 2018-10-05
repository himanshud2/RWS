package com.service.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.dao.MyProductImpl;
import com.service.model.Product;

@Path("control")
public class ProductController {
	
	MyProductImpl myProductImpl=new MyProductImpl();
	
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public void addProduct(Product p)throws Exception
	{
		myProductImpl.addProduct(p);
		System.out.println("Record added");
		
		
	}
	
	
	@Path("getAllProduct")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> products() throws Exception {

		// retrieval logic;
		return myProductImpl.products();
	}

	@Path("getProduct/{name}/{price}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Product> byNameorPrice(@PathParam("name") String name, @PathParam("price") int price) throws Exception {
		return myProductImpl.byNameorPrice(name, price);
	}

	@Path("update")
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateProduct(Product p) throws Exception {
		myProductImpl.updateProduct(p);
		return "Updated";

	}

	@Path("delete/{id}")
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	public String deleteProduct(@PathParam("id") int productid) throws Exception {
		myProductImpl.deleteProduct(productid);
		return "Record Deleted";

	}

	
	

}
