package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;




import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.PlayerAlreadyExistException;
import com.cg.model.Player;

import com.cg.repository.PlayerRepository;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest 
{
	@Mock
	private PlayerRepository pr;
	
	@InjectMocks             //used in implementation layer
	private AdminServiceImpl asl;
	
	@Test
	public void TestAddPlayer() throws PlayerAlreadyExistException 
	{
		Player p1=new Player(10,"Sachin Tendulkar",42,"Right handed Batsman and has record of 100 centuries"); // user input
		when(pr.save(any())).thenReturn(p1); //save any object to repository
		asl.addPlayer(p1); //data saved in database
		verify(pr,times(1)).save(any()); //calling any method once
	}
	
	
	@Test
	public void testGetAllPlayers()
	{
		Player p1=new Player(10,"Sachin Tendulkar",42,"Right handed Batsman and has record of 100 centuries"); // user input
		Player p2=new Player(18,"Virat Kohli",33,"Right handed Batsman and called run-machine"); //user input
		Player p3=new Player(45,"Rohit Sharma",34,"Right handed Batsman and one of the greatest opener"); //user input
		pr.save(p1); //data saved to database
		pr.save(p2); //data saved to database
		pr.save(p3); //data saved to database
		
		
		List<Player> plist=new ArrayList<>(); // crating list object
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		
		
		when(pr.findAll()).thenReturn(plist); // return player list
		List<Player> plist1 = asl.getAllPlayers();
		assertEquals(plist, plist1); //checking both objects are equal
		verify(pr,times(1)).save(p1);
		verify(pr,times(1)).findAll();
		
	
}
}