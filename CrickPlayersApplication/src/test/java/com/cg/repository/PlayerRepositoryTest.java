package com.cg.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.Player;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PlayerRepositoryTest {
	@Autowired
	private PlayerRepository playrepo;

	@Test
	public void givenPlayerShouldReturnPlayerObject() {
		Player p1 = new Player(10, "Sachin Tendulkar", 42, "Right handed Batsman and has record of 100 centuries"); // user
																													// input
		playrepo.save(p1); // data saved to database

		Player p2 = playrepo.findById(p1.getPlayerId()).get();// fetching data from database
		assertNotNull(p2); // to check if it is returning Player Object
		assertEquals(p1.getPlayerName(), p2.getPlayerName());
	}

	@Test
	public void getAllmustReturnAllPlayers() {
		Player p3 = new Player(18, "Virat Kohli", 33, "Right handed Batsman and called run-machine"); // user input
		Player p4 = new Player(45, "Rohit Sharma", 34, "Right handed Batsman and one of the greatest opener"); // user
																												// input
		playrepo.save(p3); // data saved to database
		playrepo.save(p4); // data saved to database

		List<Player> playlist1 = (List<Player>) playrepo.findAll();
		assertEquals(42, playlist1.get(4).getAge());

	}

}
