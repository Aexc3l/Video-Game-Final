package model;

public class VideoGameController {
	private Quality quality = Quality.values()[2];
	private Player[] players;
	private Level[] levels;
	private Treasure[] treasures;
	private Enemy[] enemies;
	private int maxPosX = 0;
	private int maxPosY = 0;

	public VideoGameController(int resolution) {

		this.players = new Player[20];
		this.treasures = new Treasure[50];
		this.enemies = new Enemy[25];
		this.levels = new Level[10];
		this.quality = Quality.values()[resolution];

		switch (quality) { //The game quality Selector
		case SD:
			maxPosX = 640;
			maxPosY = 480;
			break;
		case QHD:
			maxPosX = 960;
			maxPosY = 540;
			break; 
		case HD:
			maxPosX = 1280;
			maxPosY = 720;
			break;
		case FHD:
			maxPosX = 1920;
			maxPosY = 1080;
			break;
		case QUHD:
			maxPosX = 2560;
			maxPosY = 1440;
			break;    		
		case UHD:
			maxPosX = 3840;
			maxPosY = 2160;
			break;  
		case UHD8K:
			maxPosX = 7680;
			maxPosY = 4320;
			break;
		}
	}
	/**Description: This method created all the levels automatically (1-10)
	 * @return void
	*/
	public void createLevels() {

		int number = 1;

		double requiredScore = 100;

		for (int i = 0; i < levels.length; i++) {

			Level newLevel = new Level(number,requiredScore);

			if (levels[i] == null) {

				levels[i] = newLevel;
				number++;
				requiredScore = requiredScore + 100;
			}
		}		
	}

	/**Description: This method show the levels that were created automatically
	 * @return String. Shows the list of levels that have been created (1-10)
	 */	
	public String showAllLevels() {

		String allLevels = "";

		for (int i = 0; i < levels.length; i++) {

			if (levels[i] != null) {

				allLevels += levels[i].toString();
			}

		}
		return allLevels;
	}

	/**Description: This method register the players
	 * @param playerNickName String
	 * @param playerName String
	 * @param playerScore double
	 * @param availableLives int
	 * @param initialLevel int
	 * @return boolean. A boolean that shows if the player was created or not.
	 */
	public boolean registerPlayer(String playerNickName, String playerName, double playerScore, int availableLives, int initialLevel) {

		Player newPlayer = new Player(playerNickName, playerName, playerScore, availableLives, levels[initialLevel]);

		for (int i = 0; i < players.length; i++) {

			if (players[i] == null) {

				players[i] = newPlayer;
				return true;
			}
		}
		return false;
	}

	/**Description: This method register the treasures and add them to a level
	 * @param trName String
	 * @param imageURL String
	 * @param awardScore double
	 * @param lvlNum int
	 * @param repeat int
	 * @return boolean. A boolean that shows if the treasure was created or not.
	 */
	public boolean registerTreasures(String trName,String imageURL, double awardScore, int lvlNum, int repeat) {


		for (int i = 0; i < treasures.length && repeat > 0; i++){
			if (treasures[i]==null){
				Treasure newTreasure = new Treasure(trName, imageURL, awardScore);
				treasures[i] = newTreasure;
				treasures[i].setLocatedLevel(levels[lvlNum]);
				levels[lvlNum].addTreasure(treasures[i], maxPosX, maxPosY);
				repeat= repeat-1;
			}
		}
		if(repeat==0){
			return true;
		}
		return false;
	}

	/**Description: This method register the enemies
	 * @param enName String
	 * @param enType int
	 * @param loseScore double
	 * @param winScore double
	 * @return boolean. A boolean that shows if the enemy was created or not.
	 */
	public boolean registerEnemy(String enName, int enType, double loseScore, double winScore) {

		Enemy newEnemy = new Enemy( enName, enType, loseScore, winScore);

		for (int i = 0; i < enemies.length; i++) {

			if (enemies[i] == null) {

				enemies[i] = newEnemy;
				return true;
			}
		}
		return false;
	}

	/**Description: This method show all the created players 
	 * @return String. A String with the to.String() of every created players
	*/
	public String showAllPlayers() {

		String allplayers = "";

		for (int i = 0; i < players.length; i++) {

			if (players[i] != null) {

				allplayers += players[i].toString();
			}

		}
		return allplayers;
	}

	/**Description: This method show all the created treasures 
	 * @return String. A String with the to.String() of every created treasures
	*/
	public String showAllTreasures() {

		String alltreasures = "";

		for (int i = 0; i < treasures.length; i++) {

			if (treasures[i] != null) {

				alltreasures += treasures[i].toString();
			}

		}
		return alltreasures;
	}

	/**Description: This method show all the created enemies
	 * @return String. A String with the to.String() of every created enemies
	*/
	public String showAllEnemies() {

		String allenemies = "";

		for (int i = 0; i < enemies.length; i++) {

			if (enemies[i] != null) {

				allenemies += enemies[i].toString();
			}

		}
		return allenemies;
	}

	/**Description: This method check if a player nickname is already taken
	 * @param playerNick String
	 * @return boolean. A boolean to know if the player nickname exists
	 */	
	public boolean checkNickNameDisponibility(String playerNick) {

		for (int i = 0; i < players.length; i++) {
			if (players[i] == null) {
				return true;	
			}else {
				Player pl = players[i];			
				if (pl.getNickName().equals(playerNick)) {
					return false;
				}
			}
		}
		return false;
	}

	/**Description: This method check if a enemy name is already taken
	 * @param enemyName String
	 * @return boolean. A boolean to know if the enemy name exists
	 */	
	public boolean checkEnemyNameDisponibility(String enemyName) {

		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] == null) {
				return true;	
			}else {
				Enemy eN = enemies[i];			
				if (eN.getEnName().equals(enemyName)) {
					return false;
				}
			}
		}
		return false;
	}

	/**Description: This method check if a player is already on game
	 * @param playerNick String
	 * @return boolean. A boolean to know if the player exists
	 */	
	public boolean checkNameExistence(String playerNick) {

		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				Player pl = players[i];			
				if (pl.getNickName().equals(playerNick)) {
					return true;
				}
			}
		}

		return false;
	}

	/**Description: This method check if a enemy is already on game
	 * @param eNName String
	 * @return boolean. A boolean to know if the treasure exists
	 */	
	public boolean checkEnemyNameExistence(String eNName) {

		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null) {
				Enemy eN = enemies[i];			
				if (eN.getEnName().equals(eNName)) {
					return true;
				}
			}
		}

		return false;
	}

	/**Description: This method check if a treasure is already on game
	 * @param tRName String
	 * @return boolean. A boolean to know if the treasure exists
	 */	
	public boolean checkTreasureNameExistence(String tRName) {

		for (int i = 0; i < treasures.length; i++) {
			if (treasures[i] != null) {
				Treasure tR = treasures[i];			
				if (tR.getTrName().equals(tRName)) {
					return true;
				}
			}
		}

		return false;
	}

    /**Description: This method check if an enemy is already on an specific level
	 * @param enemyName String
	 * @param eNLvl int
	 * @return boolean. A boolean to know if the enemy is already in level
	 */	
	public boolean checkUnRepeatedEnemy(String enemyName, int eNLvl) {

		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] == null) {
				return true;	
			}else {
				Enemy eN = enemies[i];	
				if (eN.getLocatedLevel() == levels[eNLvl] && eN.getEnName().equals(enemyName)) {
					return false;
				}		
			}
		}
		return false;
	}

	/**Description: This method change the score of one player and
	 * change it's level automatically
	 * @param playerNick String
	 * @param newScore double
	 * @return void. Modified Player Score
	 */
	public void modifyPlayerScore(String playerNick, double newScore) {

		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				Player pl = players[i];			
				if (pl.getNickName().equals(playerNick)) {
					pl.setScore(newScore);
					for (int j = 0; j < levels.length; j++) {
						if (pl.getScore() >= levels[j].getRequiredScore()) {
							pl.setActuaLevel(levels[j]);
						}
					}
				}
			}			
		}
	}

	/**Description: This method searchs the missing score that a player needs
	 * to for the next level
	 * @param playerNick String
	 * @return double. A double of the score for next level
	 */
	public double searchMissingScore(String playerNick) {
		double msgsum =  0;
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				Player pl = players[i];
				if (pl.getNickName().equals(playerNick)) {
					for (int j = 0; j < levels.length; j++ ) {
						if (pl.getScore() < levels[j].getRequiredScore()) {
							return msgsum = levels[j].getRequiredScore() - pl.getScore(); 
						}	
					}	
				}
			}
		}
		return msgsum; 	
	}


	/**Description: This method add one enemy to a level selected for the user
	 * @param eNName String
	 * @param eNLvl int
	 * @return boolean. Shows if the enemy was added to the level or not
	 */
	public boolean addEnemyToLevel(String eNName, int eNLvl) {

		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null) {
				Enemy eN = enemies[i];			
				if (eN.getEnName().equals(eNName)) {		
					if (levels[eNLvl] != null) {
						levels[eNLvl].addEnemy(eN, maxPosX, maxPosY);
						enemies[i].setLocatedLevel(levels[eNLvl]);

						return true;
					}
				}
			}
		}
		return false;
	}

	/**Description: This method search for the enemy that gives max score in all levels
	 * @return msg String. Shows the name of the enemy and the level where it's located
	 */
	public String searchEnemyMaxScore() {
		double maxScore = 0;
		int maxEnSc = 0;
		String enemyName = "";

		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null) {
				Enemy eN = enemies[i];
				if (eN.getLocatedLevel() != null) {
					Level getMaxLvl = eN.getLocatedLevel();
					if (eN.getWinScore() >= maxScore) {
						maxEnSc = getMaxLvl.getNumber();
						enemyName = "The Enemy with the highest given score is " + eN.getEnName() + " and is located in level " + maxEnSc + " with " + eN.getWinScore() + " points."  ;
					}
				}
			}
		} 
		return enemyName;
	}

	/**Description: This method search the amount of enemies by it's type in all levels
	 * @return String. Shows the enemies by it's type in all levels
	 */
	public String searchEnemyTypeinLvl() {

		String allEnTypes = "";

		for (int i = 0; i < levels.length; i++) {

			if (levels[i] != null) {

				allEnTypes += levels[i].checkEnemiesTypes();
			}

		}
		return allEnTypes;	
	}

	/**Description: This method show the treasures select by the user in all the levels of the game
	 * @param treasName String. The name of treasures that are gonna be search
	 * @return String. Shows the amount of a treasure on every level
	 */
	public String searchTreasinLvl(String treasName) {

		String allEnTypes = "";

		for (int i = 0; i < levels.length; i++) {

			if (levels[i] != null) {

				allEnTypes += levels[i].checkTreas(treasName);
			}

		}
		return allEnTypes;
	}
	
	/**Description: This method show the treasures and enemies in a level selected by the user
	 * @param lvl int. 
	 * @return String. Shows the treasures and enemies in a level
	 */
	public String showObjinLvl(int lvl){
		String objlvl = "";
		for (int i = 0; i < levels.length ; i++) {
			if (levels[i] != null) {
				if (levels[i].getNumber() == lvl) {
					objlvl = levels[i].treasuresAndEnemies();
				}
			}
		}
		return objlvl;
	}
	
	/**Description: This method count the consonants in the name of each enemy
	 * @return String. Shows the amount of consonants in each enemy name
	 */
	public String consonantsInEnemies(){
		String consonantsInEn =  "";
		int consonants = 0;
		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null) {
				consonants = getConsonants(enemies[i].getEnName());
				consonantsInEn += "\n" + (i + 1) + ". There are " + consonants + " consonants in the name [" + enemies[i].getEnName() + "].";
			}

		}
		return consonantsInEn;
	}

	/**Description: This method get the consonants in the name of each enemy
	 * @param enemyName String
	 * @return int. Shows the amount of consonants in each enemy name
	 */
	public int getConsonants(String enemyName){
		int consonants = 0;
		for (int i=0 ; i<enemyName.length(); i++){
			char lt = enemyName.charAt(i);
			if(lt == 'a' || lt == 'e' || lt == 'i' || lt == 'o' || lt == 'u' || lt == 'A' || lt == 'E' || lt == 'I' || lt == 'O' || lt == 'U'  ){
				consonants = consonants + 0;
			}else if(lt != ' '){
				consonants++;
			}
		}
		return consonants;
	}

	/**Description: This method gets an array od top players by they score
	 * @param array double[]
	 * @return double[]. Shows the max score of a player
	 */
	public double[] getTop(double[] array) {

		double max[] = new double[2];

		for (int x = 0; x < array.length; x++) {

			if (array[x] > max[0]) {
				max[0] = array[x];
				max[1] = x;
			}

		}

		return max;
	}

	/**Description: This method creates an array with all players score
	 * @return double[]. Shows all players scores
	 */
	public double[] getAllScores(){

		double[] allScores = new double[20];

		for (int i = 0; i < players.length ; i++ ) {

			if (players[i]!= null) {

				allScores[i] = players[i].getScore();

			}
		}

		return allScores;
	}

	/**Description: This method gets the name of the player with his score
	 * @param coincidence double
	 * @return String. Shows the name of the player
	 */	
	public String getNameCoincidence(double coincidence) {

		String name = "";
		boolean match = false;
		while (!match) {

			for (int i = 0; i < players.length ; i++) {
				if (players[i] != null) {
					if (coincidence == players[i].getScore()) {
						name = players[i].getNickName();
						match = true;

					}
				}

			}

		}
		return name;
	}

	/**Description: This method creates a top with the
	 * TOP 5 players in game by they scores
	 * @return String. Shows all players scores and names
	 */
	public String getOrderedScores() {

		String top5 = "";

		double[] actualScore = getAllScores(); 

		double[] orderedScore = new double[20];

		for (int i = 0; i < actualScore.length; i++) {

			double[] result = getTop(actualScore);
			orderedScore[i] = result[0];
			actualScore[(int)result[1]] = -1;

		}


		for (int j = 0; j < 5; j++) {
			if (orderedScore[j] != 0) {
				top5 += "\nTOP " + (j + 1) + " : " + getNameCoincidence(orderedScore[j]) + " Score: " + orderedScore[j];
			}

		}

		return top5;
	}

	/**Description: This method count the most repeated treasure in game
	 * @return String. Shows the most Repeated Treasure in Game with it's winScore
	 */
	public String mostRepeatedinLvl() {

		String mostRepeatedinLvl = ""; 
		
		String colectName = "";
		int countAmount = 0;
		int countMostRep = 0;
		String mostRepName = "";

		for (int i = 0; i < treasures.length ; i++ ) {
			if (treasures[i] != null) {
				colectName = treasures[i].getTrName();
				countAmount = 0;
				for (int j = 0; j < treasures.length ; j++ ) {
					if (treasures[j] != null) {
						if (colectName.equals(treasures[j].getTrName())) {
							countAmount = countAmount + 1;
					}	
					}

				}	
			}
				if (countMostRep < countAmount) {
					countMostRep = countAmount;
					mostRepName = colectName;
				}
		}
		mostRepeatedinLvl = "The Treasure " +  mostRepName + " is the most Repeated Treasure in Game with " + countMostRep;
		return mostRepeatedinLvl;
	}
}

