package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Player;

public interface PlayerRepository extends MongoRepository<Player, Integer> {

}
