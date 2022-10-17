package model;

public class Player {

	private String nickName;
	private String plName;
	private double score;
	private int availableLives;
	private Level actualLevel;

	public Player(String nickName, String plName, double score, int availableLives, Level actualLevel) {
		this.nickName = nickName;
		this.plName = plName;
		this.score = score;
		this.availableLives = availableLives;
		this.actualLevel = actualLevel;

	}

	public String getNickName(){

		return nickName;

	}

	public void setNickName(String nickName) {

		this.nickName = nickName;
	}

	public String getName(){

		return plName;

	}

	public void setName(String plName) {

		this.plName = plName;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getAvailableLives() {
		return availableLives;
	}

	public void setAvailableLives(int availableLives) {
		this.availableLives = availableLives;
	}

	public Level getActuaLevel() {
		return actualLevel;
	}

	public void setActuaLevel(Level actualLevel) {
		this.actualLevel = actualLevel;
	}

	public String toString(){

		return "\nPlayer: " + nickName
				+"\nName: " + plName
				+"\nScore: " + score
				+"\nLives: " + availableLives
				+"\nActual Level: " + actualLevel.getNumber()
				+"\n ";
	}


}


