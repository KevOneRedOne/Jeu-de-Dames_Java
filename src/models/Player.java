package models;

public class Player {
	String name;
	String color;
	boolean isUser;
	int score;
	
	public Player(String name, String color, boolean isUser, int score) {
		super();
		this.name = name;
		this.color = color;
		this.isUser = isUser;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isUser() {
		return isUser;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", color=" + color + ", isUser=" + isUser + ", score=" + score + "]";
	}
	
	
}
