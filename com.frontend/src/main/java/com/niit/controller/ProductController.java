package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	@RequestMapping("/Product")
	public String showProducts(Model m) {
		List<Product> list=productDAO.listProducts();
		m.addAttribute("productList",list);
		Product product=new Product();
		m.addAttribute("Product",product);
		return "Product";
	}
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product) {
		productDAO.addProduct(product);
		return "redirect:/Product";
	}
	@RequestMapping("/deleteProduct/{pid}")
	public String deleteProduct(@PathVariable("pid") int pId) {
		productDAO.deleteProduct(productDAO.getProduct(pId));
		return "redirect:/Product";
	}
	@RequestMapping("/editProduct/{pid}")
	public String editProduct(@PathVariable int pid,Model m) {
		m.addAttribute("productInfo",productDAO.getProduct(pid));
		m.addAttribute("product",new Product());
		return "redirect:/Product";
	}
}
