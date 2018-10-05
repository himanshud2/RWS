package com.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.service.model.Product;
import com.service.utility.ConnectionProvider;

public class MyProductImpl implements MyProduct {
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps;
	

	@Override
	public void addProduct(Product p) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Add Product");
		int productId=p.getProductId();
		String productName=p.getProductName();
		int productPrice=p.getProductPrice();
		int totalQuantity=p.getTotalQuantity();
		String mfgDate=p.getMfgDate();
		String query="insert into product_info values(?,?,?,?,?)";
		con=ConnectionProvider.getConnection();
		ps=con.prepareStatement(query);
		ps.setInt(1, productId);
	    ps.setString(2, productName);
	    ps.setInt(3, productPrice);
		ps.setInt(4, totalQuantity);
		ps.setString(5, mfgDate);
		ps.executeUpdate();
		System.out.println("Inserted");
		
		
	}

	@Override
	public List<Product> products() throws Exception {
		// TODO Auto-generated method stub
		
		List<Product> plist=new ArrayList<>();
		con=ConnectionProvider.getConnection();
		String query="select * from product_info";
		ps=con.prepareStatement(query);
		rs=ps.executeQuery();
		Product p=new Product();
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			p.setProductId(rs.getInt(1));
			p.setProductName(rs.getString(2));
			p.setProductPrice(rs.getInt(3));
			p.setTotalQuantity(rs.getInt(4));
			p.setMfgDate(rs.getString(5));
			plist.add(p);
			
			
		}
	
		return plist;
	}

	@Override
	public List<Product> byNameorPrice(String name, int price) throws Exception {
		// TODO Auto-generated method stub
		Product pro;
		List<Product> pList = new ArrayList<Product>();
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("select * from product_Info where productname=? and productprice>=?");
		ps.setString(1,name);
		ps.setInt(2,price);
		rs = ps.executeQuery();
		while (rs.next()) {
			pro = new Product();
			System.out.println(rs.getString(1));
			pro.setProductId(rs.getInt(1));
			pro.setProductName(rs.getString(2));
			pro.setProductPrice(rs.getInt(3));
			pro.setTotalQuantity(rs.getInt(4));
			pro.setMfgDate(rs.getString(5));
			System.out.println(pro);
			pList.add(pro);
	
		
		}
		
		
		return pList;
	}

	@Override
	public void updateProduct(Product p) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Update Product");
		con = ConnectionProvider.getConnection();
		String query = "Update product_Info set PRODUCTNAME=?,PRODUCTPRICE=?,TOTALQUANTITY=?,MFGDATE=? where PRODUCTID=?  ";
		ps = con.prepareStatement(query);
		//ps.setString(4, user.getId());
		ps.setInt(5, p.getProductId());
		ps.setString(1,p.getProductName());
		ps.setInt(2, p.getProductPrice());
		ps.setInt(3, p.getTotalQuantity());
		ps.setString(4,p.getMfgDate());
		ps.executeUpdate();
		System.out.println("Updated");

		
	}

	@Override
	public void deleteProduct(int productid) throws Exception {
		// TODO Auto-generated method stub
		
		con=ConnectionProvider.getConnection();
		String query="delete * from product_info where productId=?";
		ps=con.prepareStatement(query);
		ps.setInt(1, productid);
		rs=ps.executeQuery();
		System.out.println("Deleted");
		
		
		
		
		
	}
	
	
	
	

}
