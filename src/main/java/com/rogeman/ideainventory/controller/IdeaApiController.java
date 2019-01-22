package com.rogeman.ideainventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogeman.ideainventory.exception.ResourceNotFoundException;
import com.rogeman.ideainventory.model.Idea;
import com.rogeman.ideainventory.repository.IdeaRepository;

@RestController
@RequestMapping("/api")
public class IdeaApiController {

	@Autowired
	IdeaRepository ideaRepository;
	
	//Get all Ideas
	@GetMapping("/ideas")
	public List<Idea> getAllIdeas(){
		
		return ideaRepository.findAll();
		
	}
	//Create a new Idea
	@PostMapping("/ideas")
	public Idea createIdea(@Valid @RequestBody Idea idea) {
		return ideaRepository.save(idea);
	}
	//Get a single Idea
	@GetMapping("/ideas/{id}")
	public Idea getIdeaById(@PathVariable(value="id") Long id) {
		return ideaRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Idea","id",id));
	}
	//Update an Idea
	@PutMapping("/ideas/{id}")
	public Idea updateIdea(@PathVariable(value="id") Long ideaId, @Valid @RequestBody Idea ideaDetails) {
		Idea idea = ideaRepository.findById(ideaId)
				.orElseThrow(()-> new ResourceNotFoundException("Idea","Id",ideaId));
		idea.setIdea(ideaDetails.getIdea());
		idea.setParentIdeaId(ideaDetails.getParentIdeaId());
		
		Idea updatedIdea=ideaRepository.save(idea);
		return updatedIdea;
	}
	//Delete an Idea
	@DeleteMapping("/ideas/{id}")
	public ResponseEntity<?> deleteIdea(@PathVariable(value="id") Long ideaId){
		Idea idea=ideaRepository.findById(ideaId)
				.orElseThrow(()-> new ResourceNotFoundException("Idea","id",ideaId));
		ideaRepository.delete(idea);
		
		return ResponseEntity.ok().build();
	}
}
