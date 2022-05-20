package com.cg.service;

import java.util.List;


import org.springframework.security.core.userdetails.UserDetails;

import com.cg.exception.DataNotFoundException;
import com.cg.model.Player;

public interface UserService
{
	//methods
	public List<Player> getAllPlayers();
	public Player getFavPlayers(int playerId) throws DataNotFoundException;
	
}
