package com.cg.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

//pojo class

@Document(collection = "playersdata")
public class Player {
	// private data members

	@Id
	private int playerId;
	private String playerName;
	private int age;
	private String playerInfo;

	// default constructor

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor

	public Player(int playerId, String playerName, int age, String playerInfo) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.age = age;
		this.playerInfo = playerInfo;
	}

	// getters setters

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlayerInfo() {
		return playerInfo;
	}

	public void setPlayerInfo(String playerInfo) {
		this.playerInfo = playerInfo;
	}

	// to string

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", age=" + age + ", playerInfo="
				+ playerInfo + "]";
	}

}
