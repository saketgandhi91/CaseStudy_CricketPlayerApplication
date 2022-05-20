package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.DataNotFoundException;
import com.cg.model.Player;
import com.cg.repository.PlayerRepository;

@Service
public class UserServiceImpl implements UserService {

	// to fetch data
	private PlayerRepository playrepo;

	@Autowired
	public UserServiceImpl(PlayerRepository playrepo) {
		super();
		this.playrepo = playrepo;
	}
	
	//methods

	@Override
	public List<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return (List<Player>) playrepo.findAll();
	}

	@Override
	public Player getFavPlayers(int playerId)throws DataNotFoundException 
	{

		Optional<Player> p1 = this.playrepo.findByplayerId(playerId);
		if (p1.isPresent()) 
		{
			return p1.get();
		}
		
		throw new DataNotFoundException();
	}

}
