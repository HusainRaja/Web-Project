
package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String showCategory(Model m) {
		List<Category> list=categoryDAO.listCategories();
		m.addAttribute("categoryList",list);
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
		return "redirect:/Category";
	}
	@RequestMapping(value="/deleteCategory/{cid}")
	public String deleteCategory(@PathVariable("cid") int CID,Model m) {
		System.out.println("category id ="+CID);
		Category category=categoryDAO.getCategory(CID);
		categoryDAO.deleteCategory(category);
		List<Category> list=categoryDAO.listCategories();
		m.addAttribute("categoryList",list);
		return "redirect:/Category";
		
	}
	@RequestMapping("/editCategory,{cid}")
	public String editCategory(@PathVariable("cid")int cId,Model m) {
		Category category=categoryDAO.getCategory(cId);
		m.addAttribute("categoryInfo",category);
		m.addAttribute("category",new Category());
		return "Update-Category";
	}
	@RequestMapping(value="/updateCategory", method=RequestMethod.POST)
	public String updateCategory(@ModelAttribute Category category) {
		categoryDAO.updateCategory(category);
		return "redirect:/Category";	
	}
}
