package models;

public class Score {
	String playerName;
	int nbVictories;
	int nbDefeats;
	int Score;

	public Score(String playerName, int nbVictories, int nbDefeats, int Score) {
		super();
		this.playerName = playerName;
		this.nbVictories = nbVictories;
		this.nbDefeats = nbDefeats;
		this.Score = Score;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getNbVictories() {
		return nbVictories;
	}

	public void setNbVictories(int nbVictories) {
		this.nbVictories = nbVictories;
	}

	public int getNbDefeats() {
		return nbDefeats;
	}

	public void setNbDefeats(int nbDefeats) {
		this.nbDefeats = nbDefeats;
	}

	@Override
	public String toString() {
		return "Score [playerName=" + playerName + ", nbVictories=" + nbVictories + ", nbDefeats=" + nbDefeats + ", Score=" + Score + "]";
	}
}