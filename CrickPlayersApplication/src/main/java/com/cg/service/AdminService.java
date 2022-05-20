package com.cg.service;

import java.util.List;
import com.cg.exception.PlayerAlreadyDeletedException;
import com.cg.exception.PlayerAlreadyExistException;
import com.cg.model.Player;


public interface AdminService 
{
	//methods
	public Player addPlayer(Player play) throws PlayerAlreadyExistException;
	public List<Player> getAllPlayers();
	public void deletePlayerListByplayerId(int playerId)  throws PlayerAlreadyDeletedException;
	public Player UpdatePlayer(Player p1);
}
