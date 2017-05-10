/**
 * 
 */
package com.scart.jcart.site.web.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scart.jcart.catalog.CatalogService;
import com.scart.jcart.entities.Category;
import com.scart.jcart.entities.NewsLetterSubscriber;
import com.scart.jcart.entities.Product;
import com.scart.jcart.newsletter.NewsLetterSubscriberService;

/**
 * @author Siva
 *
 */
@Controller
public class HomeController extends SCartSiteBaseController {
	@Autowired
	private CatalogService catalogService;

	@Autowired
	private NewsLetterSubscriberService newsLetterSubscriberService;

	@Override
	protected String getHeaderTitle() {
		return "Home";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		List<Category> previewCategories = new ArrayList<>();
		List<Category> categories = catalogService.getAllCategories();
		for (Category category : categories) {
			Set<Product> products = category.getProducts();
			Set<Product> previewProducts = new HashSet<>();
			int noOfProductsToDisplay = 4;
			if (products.size() > noOfProductsToDisplay) {
				Iterator<Product> iterator = products.iterator();
				for (int i = 0; i < noOfProductsToDisplay; i++) {
					previewProducts.add(iterator.next());
				}
			} else {
				previewProducts.addAll(products);
			}
			category.setProducts(previewProducts);
			previewCategories.add(category);
		}
		model.addAttribute("categories", previewCategories);
		return "home";
	}

	@RequestMapping("/categories/{name}")
	public String category(@PathVariable String name, Model model) {
		Category category = catalogService.getCategoryByName(name);
		model.addAttribute("category", category);
		return "category";
	}

	/*
	@RequestMapping(value="/home", method=RequestMethod.GET)
	protected String subscribeForm(Model model){
		model.addAttribute("subscribe", new NewsLetterSubscriber());
		return "home";
	}
*/
	@RequestMapping(value = "/subscribe", method = RequestMethod.POST)
	protected String subscriber(@ModelAttribute("subscribe") NewsLetterSubscriber newSub, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "home";
		}
		newSub.setCustomer_id(0);
		newSub.setSubscriber_status(1);
		NewsLetterSubscriber presistedNews = newsLetterSubscriberService.createNewsLetterSubscriber(newSub);
		logger.debug("Created new NewsLetterSubscriber with email : {}", presistedNews.getSubscriber_email());
		redirectAttributes.addFlashAttribute("info", "NewsLetter Subscribered successfully");

		return "redirect:/home";
	}
}
