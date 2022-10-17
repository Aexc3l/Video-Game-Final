package model;

public class Treasure {

	private String trName;
	private String imageURL;
	private double awardScore;
	private int xPosition = 0;
	private int yPosition = 0;
	private Level locatedLevel = null;

	public Treasure(String trName,String imageURL, double awardScore) {

		this.trName = trName;
		this.imageURL = imageURL;
		this.awardScore = awardScore;
	}

	public String getTrName() {

		return trName;

	}

	public void setTrName(String trName) {
		this.trName = trName;

	}

	public String getImageURL() {

		return imageURL;

	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;

	}

	public double getAwardScore() {

		return awardScore;

	}

	public void setAwardScore(double awardScore) {
		this.awardScore = awardScore;

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

	public String toString() {

		return "\nTreasure Info"
				+ "\nName: " + trName
				+ "\nImage URL: " + imageURL
				+ "\nScore Given to The Player: " + awardScore
				+ "\nLocated Level: " + locatedLevel.getNumber()
				+ "\nPositions: " + xPosition + " x " + yPosition
				+ "\n";
	}

}
