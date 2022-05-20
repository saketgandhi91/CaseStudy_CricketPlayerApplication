package com.cg.controller;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.PlayerAlreadyDeletedException;
import com.cg.exception.PlayerAlreadyExistException;

import com.cg.model.Player;

import com.cg.service.AdminService;

@RestController
@RequestMapping("api/v1")
public class CrickPlayersController 
{
	private AdminService as;

	
	@Autowired
	public CrickPlayersController(AdminService as) {
		super();
		this.as = as;
	}
	
	@PostMapping("/play")
	public ResponseEntity<Player> addPlayer(@RequestBody Player play ) throws PlayerAlreadyExistException
	{
        Player p1 = as.addPlayer(play);
        return new ResponseEntity<>(p1, HttpStatus.CREATED);
    }
	
	
	@GetMapping("/players")
	public ResponseEntity<List<Player>> getAllPlayers() 
	{
        return new ResponseEntity<List<Player>>((List<Player>)as.getAllPlayers(),HttpStatus.OK);
    }
	
	
	@DeleteMapping("/playdel/{PlayerId}") 
	public ResponseEntity<Void> deletePlayerListByplayerId(@PathVariable int PlayerId) throws PlayerAlreadyDeletedException
	{
        as.deletePlayerListByplayerId(PlayerId);
        return ResponseEntity.noContent().build();
    }
	
	
	@PutMapping("/upplayer")
	public Player UpdatePlayer(@RequestBody Player p1)
	{
		return as.UpdatePlayer(p1);
    }
}