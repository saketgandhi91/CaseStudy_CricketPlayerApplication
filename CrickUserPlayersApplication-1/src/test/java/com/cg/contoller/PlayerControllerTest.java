package com.cg.contoller;

import static org.mockito.ArgumentMatchers.any;



import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.controller.CrickPlayersController;

import com.cg.model.Player;


import com.cg.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest 
{
	@Autowired
	private MockMvc mockmvc; //class 
	
	@Mock
	private UserService ar;
	private Player pt;
	private List<Player> ptd;
	
	
	@InjectMocks
	private CrickPlayersController pc;
	
	
	@BeforeEach
	public void setUp()
	{
		pt=new Player(10,"Sachin Tendulkar",42,"Right handed Batsman and has record of 100 centuries");
		mockmvc=MockMvcBuilders.standaloneSetup(pc).build();
	}
	

	
	@Test
	public void getAllPlayersControllerTest() throws Exception
	{
		when(ar.getAllPlayers()).thenReturn(ptd);
		mockmvc.perform(MockMvcRequestBuilders.get("/api/v1/players")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJSONString(pt)))
		.andDo(MockMvcResultHandlers.print()); //print JSON object
		verify(ar,times(1)).getAllPlayers();
		
	}
	
	
	
	
	
	public static String asJSONString(final Object obj) {
		// TODO Auto-generated method stub
		try
		{
		return new ObjectMapper().writeValueAsString(obj);
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}


	
	
}
