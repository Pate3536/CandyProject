package ca.sheridancollege.pate3536.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import ca.sheridancollege.pate3536.beans.Candy;
import ca.sheridancollege.pate3536.database.DatabaseAccess;

@Controller
public class CandyController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model,@ModelAttribute Candy candy) {
		
		model.addAttribute("candy", new Candy());
		model.addAttribute("candyList", da.getCandyList());
		return "index";
	}
	
	@PostMapping("/addCandy")
    public String insertCandy(Model model,@ModelAttribute Candy candy) {
		
		da.insertCandy(candy);
		model.addAttribute("candy", new Candy());
		model.addAttribute("candyList", da.getCandyList());
		
		return "index";
	}
	
	@GetMapping("/editCandyById/{id}")
	public String editCandyById(Model model, @PathVariable Long id) {
		
		Candy candy = da.getCandyById(id).get(0);
		model.addAttribute("candy", candy);
		da.deleteCandyById(id);
		model.addAttribute("candyList", da.getCandyList());
		return "update_candy";
	}
	
	@GetMapping("/deleteCandyById/{id}")
	public String deleteCandyById(Model model, @PathVariable Long id) {
		
		da.deleteCandyById(id);
		model.addAttribute("candy", new Candy());
		model.addAttribute("candyList", da.getCandyList());
		
		return "data";
	}
	
	@GetMapping("/data")
	public String data(Model model,@ModelAttribute Candy candy) {
		
		model.addAttribute("candy", new Candy());
		model.addAttribute("candyList", da.getCandyList());
		return "data";
	}
	
	
	
}
