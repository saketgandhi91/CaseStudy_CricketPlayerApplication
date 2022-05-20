package com.cg.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Player;

public interface PlayerRepository extends MongoRepository<Player, Integer> {

	//method
	public Optional<Player> findByplayerId(int playerId);
}
