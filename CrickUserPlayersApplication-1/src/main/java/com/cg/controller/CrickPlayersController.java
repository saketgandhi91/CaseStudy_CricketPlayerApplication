package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.DataNotFoundException;
import com.cg.model.Player;

import com.cg.service.UserService;

@RestController
@RequestMapping("api/v1")
public class CrickPlayersController 
{
	private UserService as;

	
	@Autowired
	public CrickPlayersController(UserService as) {
		super();
		this.as = as;
	}
	
	
	//methods
	
	@GetMapping("/players")
	public ResponseEntity<List<Player>> getAllPlayers() 
	{
        return new ResponseEntity<List<Player>>((List<Player>)as.getAllPlayers(),HttpStatus.OK);
    }
	
	
	@GetMapping("/favplay/{playerId}")
	public ResponseEntity	 <Player> getFavPlayers(@PathVariable int playerId) throws DataNotFoundException
	{
		
		return ResponseEntity.ok().body(as.getFavPlayers(playerId));
		
	}
	
}
