package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;
	@RequestMapping("/Category")
	public String showCategory() {
		return "Category";
	}
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("catname")String catname,@RequestParam("catdesc")String catdesc,Model m) {
		//System.out.println("category,"+catname+" "+catdesc);
		Category category=new Category();
		category.setCategoryDesc(catdesc);
		category.setCategoryName(catname);
		categoryDAO.addCategory(category);
		List<Category> list=categoryDAO.listCategories();
		m.addAttribute("categoryList",list);
		return "Category";
	}
}
