package model;
import java.util.Random;

public class Level {

	private int number;
	private Complexity levelComplexity;
	private double requiredScore;
	private Enemy[] enemyList;
	private Treasure[] treasureList;
	private static Random random = new Random();

	public Level(int number, double requiredScore) {

		this.number = number;
		this.requiredScore = requiredScore;
		this.enemyList = new Enemy[25];
		this.treasureList = new Treasure[50];


	}

	public int getNumber(){
		return this.number;

	}

	public void setNumber(int number){
		this.number = number;

	}

	public double getRequiredScore(){
		return this.requiredScore;

	}

	public void setRequiredScore(double requiredScore){
		this.requiredScore = requiredScore;

	}


	/**Description: This method add one enemy to a level
	 * and asign it's positions (x,y)
	 * @param addedEnemy Enemy
	 * @param  mXPos int
	 * @param  mYPos int
	 * @return void.The added Enemy in Level
	 */
	public void addEnemy(Enemy addedEnemy, int mXPos, int mYPos) {
		boolean notAdded = true;
		int genX = 0;
		int genY = 0;

		for (int i = 0; i < enemyList.length && notAdded; i++) {
			if (enemyList[i] == null) {
				enemyList[i] = addedEnemy;
				while (notAdded) {
					genX = random.nextInt(mXPos);
					genY = random.nextInt(mYPos);
					boolean checkEnd = checkPosition( genX, genY);
					if (checkEnd) {
						addedEnemy.setPositionX(genX);
						addedEnemy.setPositionY(genY);
						notAdded = false;
					}
				}

			}
		}
		calculateComplexity();
	}

	/**Description: This method add one treasure to a level
	 * and asign it's positions (x,y)
	 * @param addedTreasure Treasure
	 * @param  mXPos int
	 * @param  mYPos int
	 * @return void. The added Treasure in Level
	 */
	public void addTreasure(Treasure addedTreasure, int mXPos, int mYPos) {
		boolean notAdded = true;
		int genX = 0;
		int genY = 0;

		for (int i = 0; i < treasureList.length && notAdded; i++) {
			if (treasureList[i] == null) {
				treasureList[i] = addedTreasure;
				while (notAdded) {
					genX = random.nextInt(mXPos);
					genY = random.nextInt(mYPos);
					boolean checkEnd = checkPosition( genX, genY);
					if (checkEnd) {
						addedTreasure.setPositionX(genX);
						addedTreasure.setPositionY(genY);
						notAdded = false;
					}
				}

			}
		}
		calculateComplexity();
	}

	/**Description: This method checks if the positions for a enemy or treasure
	 * are not repeated in a same level
	 * @param  xPos int
	 * @param  yPos int
	 * @return boolean. A boolean to know if the positions are allready taken
	 */
	public boolean  checkPosition(int xPos, int yPos) {

		for (int i = 0; i < enemyList.length; i++) {
			if (enemyList[i] == null ) {
				return true;
			}else {
				Enemy eN = enemyList[i];			
				if (eN.getPositionY() == yPos) {
					return false;
				}else {
					for (int j = 0; j < treasureList.length; j++ ) {
						if (treasureList[j] == null ) {
							return true;
						}else {
							Treasure tR = treasureList[j];
							if (tR.getPositionY() == yPos) {
								return false;
							}
						}
					}
				}	
			}
		}

		for (int h = 0; h < enemyList.length; h++) {
			if (enemyList[h] == null ) {
				return true;
			}else {
				Enemy eN = enemyList[h];			
				if (eN.getPositionX() == xPos) {
					return false;
				}else {
					for (int k = 0; k < treasureList.length; k++ ) {
						if (treasureList[k] == null ) {
							return true;
						}else {
							Treasure tR = treasureList[k];
							if (tR.getPositionX() == xPos) {
								return false;
							}
						}
					}
				}	
			}
		}

		return false;
	}

	/**Description: This method shows the added treasures and enemies in this level
	 * @return String. The names of every added Treasure and Enemy
	 */
	public String treasuresAndEnemies(){
		String en = "";
		String tr = "";
		for (int i = 0;i < enemyList.length ; i++ ) {
			if (enemyList[i] != null) {
				en+= enemyList[i].getEnName() + ",";
			}
		}

		for (int i = 0;i < treasureList.length ; i++ ) {
			if (treasureList[i] != null) {
				tr+= treasureList[i].getTrName() + ",";
			}
		}
		return "\n Treasures: " + tr
				+ "\n Enemies: " + en;
	}

	/**Description: Calculate The complexity for a level with
	 * the scores of enemies and treasures in it
	 * @return void. The new Complexity for Level
	 */
	public void calculateComplexity(){ 
		double enemiesScore = 0; 
		double treasureScore = 0; 

		for (int i = 0;i < enemyList.length ; i++ ) {
			if (enemyList[i] != null) {
				enemiesScore += enemyList[i].getWinScore();
			}
		}
		for (int i = 0;i < treasureList.length ; i++ ) {
			if (treasureList[i] != null) {
				treasureScore += treasureList[i].getAwardScore();
			}

		}

		if (treasureScore > enemiesScore) {
			levelComplexity = Complexity.values()[0];
		}else if (treasureScore == enemiesScore) {
			levelComplexity = Complexity.values()[1];
		}else if (treasureScore < enemiesScore) {
			levelComplexity = Complexity.values()[2];
		}

	}

	/**Description: This method coounts the amount of enemies by it's type in the level
	 * @return String. Shows the enemies by it's type in the level
	 */
	public String checkEnemiesTypes(){
		int typeO = 0;
		int typeA = 0;
		int typeB = 0;
		int typeM = 0;

		for (int i = 0; i < enemyList.length; i++ ) {
			if (enemyList[i] != null) {
				Enemy eN = enemyList[i];
				switch (eN.getEnType()) {
				case "OGRE":
					typeO++;
					break;
				case "ABSTRACT": 
					typeA++;
					break;
				case "BOSS": 
					typeB++;
					break;
				case "MAGICAL": 
					typeM++;
					break;
				}	
			}

		}

		return  "\nLevel " + number + " Enemies Types: "
		+"\nOGRE: " + typeO
		+"\nABSTRACT: " + typeA
		+"\nBOSS: " + typeB
		+"\nMAGICAL: " + typeM;
	}

	/**Description: This method coounts the amount of treasure by it's name in the level
	 * @param  treasName String
	 * @return String. Shows the treasures by name in the level
	 */
	public String checkTreas(String treasName){

		String tRALL = "";
		int repeteance = 0;

		for (int i = 0; i < treasureList.length; i++ ) {
			if (treasureList[i] != null) {
				Treasure tR = treasureList[i];
				if (tR.getTrName().equals(treasName)) {
					repeteance++;
					tRALL = "There are " + repeteance + " " + treasName + "treasures";
				}
			}	
		}
		return "\nLevel: " + number
				+"\n" +tRALL;
	}

	public String toString(){
		int enemies = 0; 
		int treasures = 0;

		for (int i = 0;i < enemyList.length ; i++ ) {
			if (enemyList[i] != null) {
				enemies++;
			}
		}

		for (int i = 0;i < treasureList.length ; i++ ) {
			if (treasureList[i] != null) {
				treasures++;
			}
		}
		return 	 "\nLevel: " + number
				+"\nComplexity: " + levelComplexity
				+"\nRequired Score: " + requiredScore
				+"\n Treasures in Level: " + treasures
				+"\n Enemies in Level: " + enemies;
	}
}


