package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	@Autowired 
	CategoryDAO categoryDAO;
	@RequestMapping("/Product")
	public String showProducts(Model m) {
		List<Product> list=productDAO.listProducts();
		m.addAttribute("productList",list);
		Product product=new Product();
		m.addAttribute("Product",product);
		m.addAttribute("categoryList",this.getCategories());
		return "Product";
	}
	 @PostMapping(value = "/addProduct", consumes = "multipart/form-data")
	public String addProduct(@RequestParam MultipartFile pimage,@ModelAttribute Product product,Model m) {
		System.out.println("chaech123");
		productDAO.addProduct(product);
		String path="C:\\Users\\Husain Raja\\git\\niit-project\\com.frontend\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(product.getProductId())+".jpg";
		File file=new File(path);
		if(!pimage.isEmpty()) {
			try {
				byte[] buffer=pimage.getBytes();
				FileOutputStream fs=new FileOutputStream(file);
				BufferedOutputStream bs=new BufferedOutputStream(fs);
				bs.write(buffer);
				m.addAttribute("ErrorInfo","All good!");
				bs.close();
			}
			catch(Exception e) {
				m.addAttribute("ErrorInfo","Error in writing to file "+e);
			}
		}
		else {
			m.addAttribute("ErrorInfo","Error.. file is empty");
		}
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
		m.addAttribute("Product",new Product());
		System.err.println("check2345");
		return "Product-update";
	}
	@RequestMapping(value="/productUpdate",method=RequestMethod.POST)
	public String productUpdate(@ModelAttribute("product") Product product) {
		System.err.println("check234");
		productDAO.updateProduct(product);
		return "redirect:/Product";
	}
	public LinkedHashMap<Integer,String> getCategories() {
		List<Category> categoryLists = categoryDAO.listCategories();
		LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
		for(Category category:categoryLists) {
			categoryList.put(category.getCategoryId(), category.getCategoryName());
		}
		return categoryList;
	}
}
