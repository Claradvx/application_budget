package fr.poec.java.application_budget.Dto;

import fr.poec.java.application_budget.Entities.User;

public class ParticipantDto {

	private int id;
	
	private String username;
	
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ParticipantDto(String username, User user) {
		super();
		this.username = username;
		this.user = user;
	}
	
	public ParticipantDto(String username) {
		super();
		this.username = username;
	}

	public ParticipantDto() {
		super();
	}
	
}
