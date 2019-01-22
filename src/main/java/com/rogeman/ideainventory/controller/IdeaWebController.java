package com.rogeman.ideainventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rogeman.ideainventory.model.Idea;
import com.rogeman.ideainventory.repository.IdeaRepository;

@Controller
public class IdeaWebController {
	@Autowired
	IdeaRepository ideaRepository;
	
	@RequestMapping("/idea")
	public String ideaInventoryNoPost() {
			
		return "ideasinventory";
	}
		
	@PostMapping("/idea")
	public String ideaInventory(@RequestParam(name="sendingIdea", required=false, defaultValue="") String idea,Model model) {
		model.addAttribute("anIdea",idea);
		Idea gotIdea = new Idea(idea,0);
		ideaRepository.save(gotIdea);
		return "ideasinventory";
	}
	
	

}
