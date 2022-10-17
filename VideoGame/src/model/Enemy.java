package model;

public class Enemy {

	private String enName;
	private Types enType;
	private double loseScore;
	private double winScore;
	private int xPosition = 0;
	private int yPosition = 0;
	private Level locatedLevel = null;

	public Enemy(String enName, int enType, double loseScore, double winScore) {

		this.enName = enName;
		this.enType = Types.values()[enType-1];
		this.loseScore = loseScore;
		this.winScore = winScore;
	}

	public String getEnName() {

		return enName;

	}

	public void setEnName(String enName) {
		this.enName = enName;

	}

	public double getLoseScore() {

		return loseScore;

	}

	public void setLoseScore(double loseScore) {
		this.loseScore = loseScore;

	}

	public double getWinScore() {

		return winScore;

	}

	public void setWinScore(double winScore) {
		this.winScore = winScore;

	}

	public Level getLocatedLevel() {

		return locatedLevel;

	}

	public void setLocatedLevel(Level locatedLvl) {
		locatedLevel = locatedLvl;

	}

	public int getPositionX() {

		return xPosition;

	}

	public void setPositionX(int xPos) {
		xPosition = xPos;

	}

	public int getPositionY() {

		return yPosition;

	}

	public void setPositionY(int yPos) {
		yPosition = yPos;

	}

	/**Description: Turn the Type(Enum) of the enemy to a String
	 * @return String. Show The enemy Type
	*/
	public String getEnType() {

		String type = "";

		switch (enType) {
		case OGRE:
			type = "OGRE";
			break;
		case ABSTRACT: 
			type = "ABSTRACT";
			break;
		case BOSS: 
			type = "BOSS";
			break;
		case MAGICAL: 
			type = "MAGICAL";
			break;
		}

		return type;
	}

	public String toString() {

		String positions = xPosition + " x " + yPosition;
		String locLvl = "None";

		if (locatedLevel != null) {
			locLvl = locatedLevel.getNumber() + "";
		}

		return "\nEnemy: " + enName
				+ "\nType: " + enType
				+ "\nIn case "+ enName + " gets kill by player: " + loseScore + " points"
				+ "\nIn case " + enName + " win the player: " + winScore + " points"
				+ "\nPositions: " + positions
				+"\nLocated Level: " + locLvl
				+ "\n ";
	}

}
