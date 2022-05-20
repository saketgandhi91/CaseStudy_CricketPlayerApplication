package com.cg.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.PlayerAlreadyDeletedException;
import com.cg.exception.PlayerAlreadyExistException;
import com.cg.model.Player;

import com.cg.repository.PlayerRepository;

@Service
public class AdminServiceImpl implements AdminService 
{
	
	// to fetch data
	private PlayerRepository playrepo;
	
	
	@Autowired
	public AdminServiceImpl(PlayerRepository playrepo) {
		super();
		this.playrepo = playrepo;
	}

	
	//get all details from table
	
	@Override
	public List<Player> getAllPlayers() 
	{
		return (List<Player>) playrepo.findAll();
	}

	
	//// adding data in table 
	
	@Override
	public Player addPlayer(Player play) throws PlayerAlreadyExistException 
	{
		if(playrepo.existsById(play.getPlayerId()))
		{
			throw new PlayerAlreadyExistException();
		}
		Player p1=playrepo.save(play);
		return p1;
		
	}

	
	// delete record by playerId
	
	@Override
	public void deletePlayerListByplayerId(int playerId) throws PlayerAlreadyDeletedException 
	{
		if(playrepo.findById(playerId).isPresent())
		{
			playrepo.deleteById(playerId);
		}
	
		throw new PlayerAlreadyDeletedException();
	}

	//update record by playerId
	
	@Override
	public Player UpdatePlayer(Player p1) {
		Player p;
		Optional<Player> opt =playrepo.findById(p1.getPlayerId());
		if(opt.isPresent()) {
			p=opt.get();
			p.setPlayerName(p1.getPlayerName());
			p.setAge(p1.getAge());
			p.setPlayerInfo(p1.getPlayerInfo());
			playrepo.save(p);
			}else {
			return new Player();
			}
			return p;
		
	}

}
