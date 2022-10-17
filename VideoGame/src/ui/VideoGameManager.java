/**
 * Desc:The program allows the user to manage diferent parameters
 * for a game video game like: 
 * - Players
 * - Enemies
 * - Treasures
 * - Game Quality
 * 
 * @author: Alexandro Cabezas Lasso
 * @version: 17/10/2022
 */
package ui;

import model.VideoGameController;
import java.util.Scanner;

public class VideoGameManager {

	private static  Scanner scan = new Scanner(System.in);

	private static  VideoGameController gameControler;

	private static  boolean exit = false;

	private static int decision = 0;

	private static double initialScore = 10;

	private static int initialLives = 5;

	private static int initialLevel = 0;

	private static int registerpl = 0;

	private static int registerEn = 0;

	private static int registerTr = 0;

	/**Description: This method show to the user a general menu
	 * @return void. The main Menu
	 */
	public static void mainMenu() {

		while (!exit) {
			System.out.println("\nHERE COMES A NEW CHALLENGER!"
					+ "\nSelect an option"
					+ "\n[1] Manage Players"
					+ "\n[2] Manage Enemies"
					+ "\n[3] Manage Treasures"
					+ "\n[4] See all Levels"
					+ "\n[5] Exit");

			int choice = scan.nextInt();

			switch (choice) {

			case 1:
				playerConfig();
				break;
			case 2:
				enemyConfig();
				break;
			case 3:
				treasureConfig();
				break;
			case 4:
				levelsConfig();
				break;
			default:
				exit = true;
				break;
			}
		}
	}

    /**Description: This method show to the user a menu with the 
     * funtions that allows him to the game Quality
	 * @return void. The Configuration for the Quality IN GAME
	 */		
	public static void vdConfig() {

		System.out.println("\n "
				+"\nChoose a Display Resolution"
				+ "\n[1] SD (640 x 480)"
				+ "\n[2] QHD (960 x 540)"
				+ "\n[3] HD (1280 x 720)"
				+ "\n[4] FHD (1920 x 1080)"
				+ "\n[5] UHD (2560 x 1440)"
				+ "\n[6] UHD (3840 x 2160)"
				+ "\n[7] UHD 8K (7680 x 4320)");

		int resolution = scan.nextInt()-1;

		gameControler = new VideoGameController(resolution);
		gameControler.createLevels();
		mainMenu();
	}

    /**Description: This method show to the user a menu with the 
     * functions that can be done with the a player
	 * @return void. The Configuration for the players
	 */	
	private static void playerConfig() {
		while (!exit) {
			System.out.println("\n "
					+"\nChoose an Option"
					+ "\n[1] Create a Player"
					+ "\n[2] See all Player"
					+ "\n[3] Modify a Player's Score"
					+ "\n[4] See Top Players"
					+ "\n[5] Go Back");

			decision = scan.nextInt();

			switch (decision) {
			case 1:
				registerPlayer();
				break;
			case 2:
				if (registerpl > 0) {
					System.out.println(gameControler.showAllPlayers());
				} else {
					System.out.println("You haven't registered any players yet");
				}
				break;
			case 3:
				if (registerpl > 0) {
					modifyPlayerScore();
				} else {
					System.out.println("You haven't registered any players yet");
				}
				break;
			case 4:
				if (registerpl > 0) {
					System.out.println(gameControler.getOrderedScores());
				} else {
					System.out.println("You haven't registered any players yet");
				}
				break;
			default:
				mainMenu();
				break;}
		}
	}

    /**Description: This method show to the user a menu with the 
     * functions that can be done with the a enemy
	 * @return void. The Configuration for the enemies
	 */
	private static void enemyConfig() {
		while (!exit) {
			System.out.println("\n "
					+"\nChoose an Option"
					+ "\n[1] Create an Enemy"
					+ "\n[2] See all Enemies"
					+ "\n[3] Add a Enemy to a Level"
					+ "\n[4] See consonants in enemies names"
					+ "\n[5] See Most Score Given Enemy"
					+ "\n[6] Go Back");

			decision = scan.nextInt();

			switch (decision) {
			case 1:
				registerEnemy();
				break;
			case 2:
				if (registerEn > 0) {
					System.out.println(gameControler.showAllEnemies());
				} else {
					System.out.println("You haven't registered any enimies yet");
				}
				break;
			case 3:
				if (registerEn > 0) {
					addEnemyToLevel();
				} else {
					System.out.println("You haven't registered any enemies yet");
				}
				break;
			case 4:
				if (registerEn > 0) {
					System.out.println(gameControler.consonantsInEnemies());
				} else {
					System.out.println("You haven't registered any enemies yet");
				}
				break;
			case 5:
				if (registerEn > 0) {
					System.out.println(gameControler.searchEnemyMaxScore());
				} else {
					System.out.println("You haven't registered any enemies yet");
				}
				break;
			default:
				mainMenu();
				break;}
		}
	}

    /**Description: This method show to the user a menu with the 
     * functions that can be done with the a treasure
	 * @return void. The Configuration for the treasures 
	 */	
	private static void treasureConfig() {
		while (!exit) {
			System.out.println("\n "
					+"\nChoose an Option"
					+ "\n[1] Create a Treasure"
					+ "\n[2] See all Treasures"
					+ "\n[3] See the most repeated treasure in all levels."
					+ "\n[4] Go Back");

			decision = scan.nextInt();

			switch (decision) {
			case 1:
				registerTreasure();
				break;
			case 2:
				if (registerTr > 0) {
					System.out.println(gameControler.showAllTreasures());
				} else {
					System.out.println("You haven't registered any treasures yet");
				}
				break;
			case 3:
				if (registerTr > 0) {
					System.out.println(gameControler.mostRepeatedinLvl());
				} else {
					System.out.println("You haven't registered any treasures yet");
				}
				break;
			default:
				mainMenu();
				break;}
		}
	}

    /**Description: This method show to the user a menu with the 
     * functions that can be done with the a levels
	 * @return void. The Configuration for the levels
	 */	
	private static void levelsConfig() {
		while (!exit) {
			System.out.println("\n "
					+"\nChoose an Option"
					+ "\n[1] See All Levels"
					+ "\n[2] Check Treasures and Enemies in all Levels"
					+ "\n[3] Check Enemies by Types in all Levels"
					+ "\n[4] Check Treasures by Name in all Levels"
					+ "\n[5] Go Back");

			decision = scan.nextInt();

			switch (decision) {
			case 1:
				System.out.println(gameControler.showAllLevels());
				break;
			case 2:
				checkLvl();
				break;
			case 3:
				System.out.print(gameControler.searchEnemyTypeinLvl());	
				break;
			case 4:
				if (registerTr > 0) {
					searchTreasInAllLvl();
				} else {
					System.out.println("You haven't registered any treasures yet");
				}		
				break;
			default:
				mainMenu();
				break;}
		}
	}

    /**Description: This method register a player
	 * @return void. The player on game
	 */
	private static void registerPlayer() {

		boolean checkDisp = false;
		String playerNickName = "";
		scan.nextLine();

		while (!checkDisp) {

			System.out.println("\nType the Player NickName");
			playerNickName = scan.nextLine();

			boolean disponibility = gameControler.checkNickNameDisponibility(playerNickName);

			if (disponibility) {
				checkDisp = true;
			}else {
				System.out.print("\nThis NickName is already taken, Please type another");
			}
		}

		System.out.println("Type Player's Name");
		String playerName = scan.nextLine();

		if (gameControler.registerPlayer(playerNickName, playerName, initialScore, initialLives, initialLevel)) {
			System.out.println("Player successfully registered");
		} else {
			System.out.println("Failed to register Player");
		}
		registerpl = registerpl + 1;
	}

    /**Description: This method register a enemy
	 * @return void. The enemy on game
	 */	
	private static void registerEnemy() {

		boolean checkEnNameDisp = false;
		String enemyName = "";
		scan.nextLine();

		while (!checkEnNameDisp) {

			System.out.println("\nType the Enemy Name");
			enemyName = scan.nextLine();

			boolean disponibility = gameControler.checkEnemyNameDisponibility(enemyName);

			if (disponibility) {
				checkEnNameDisp = true;
			}else {
				System.out.print("\nThis Enemy Name is already taken, Please type another");
			}
		}

		System.out.println("\nChoose the Enemy Type"
				+ "\n[1] OGRE"
				+ "\n[2] ABSTRACT"
				+ "\n[3] BOSS"
				+ "\n[4] MAGICAL");
		int enType = scan.nextInt();

		System.out.println("Type the score in case the player gets killed by the enemy");
		double loseScore = scan.nextDouble();

		System.out.println("Type the score in case the player kills the enemy");
		double winScore = scan.nextDouble();

		if (gameControler.registerEnemy(enemyName, enType, loseScore, winScore)) {
			System.out.println("Enemy successfully registered");
		} else {
			System.out.println("Failed to register Enemy");
		}
		registerEn = registerEn + 1;
	}

    /**Description: This method register a treasure in a level 
     * chosen by the user the amount of times that the user decides (50 Max)
	 * @return void. The added Treasure in Level
	 */	
	private static void registerTreasure() {

		scan.nextLine();

		System.out.println("\nType the Treasure Name");
		String trName = scan.nextLine();

		System.out.println("\nType the Image URL");
		String imageURL = scan.nextLine();

		System.out.println("\nType the score in case the player founds the Treasure");
		double awardScore = scan.nextDouble();

		System.out.println("Type the Level where you want to add the treasure to (1-10)");
		int selLvl = scan.nextInt();

		System.out.println("Type the amount of threasures you want to locate in level [" + selLvl + "]");
		int repeat = scan.nextInt();

		if (gameControler.registerTreasures(trName, imageURL, awardScore, selLvl-1, repeat)){
			System.out.println("\nTreasure successfully registered ");
		}
		else{
			System.out.println("\nFailed to register Treasure");

		}
		registerTr = registerTr + 1;
	}

    /**Description: This method modify the score of a player selected for the user
	 * @return void. The new Score of the player
	 */
	private static void modifyPlayerScore() {
		scan.nextLine();
		boolean modPl = false;
		String modPlayer = "";

		while (!modPl) {

			System.out.println("\nPlease Type the NickName of the Player");
			modPlayer = scan.nextLine();

			boolean existence = gameControler.checkNameExistence(modPlayer);

			if (existence) {
				modPl = true;
			}else {
				System.out.print("\nThis NickName does not exist, Please type another");
			}
		}

		System.out.println("\nPlease Type the New Score of the Player");
		double playerNewScore = scan.nextDouble();

		gameControler.modifyPlayerScore(modPlayer,playerNewScore);

		System.out.println("Score Successfully Changed");
		System.out.println("For Next Level, You Will Need: " + gameControler.searchMissingScore(modPlayer) + " points");
	}

    /**Description: This method add one enemy to a level 
     * chosen by the user
	 * @return void. The added Enemy in Level
	 */
	private static void addEnemyToLevel(){
		scan.nextLine();

		boolean modEn = false;
		String eNName = "";
		int eNLvl = 0;
		boolean modLvl = false;

		while (!modEn) {

			System.out.println("Type Enemy's Name");
			eNName = scan.nextLine();

			boolean existence = gameControler.checkEnemyNameExistence(eNName);

			if (existence) {
				modEn = true;
			}else {
				System.out.print("\nThis Enemy does not exist, Please type another");
			}
		}		

		while (!modLvl) {
			System.out.println("Type the Level in which you want to locate the enemy (1-10)");
			eNLvl = scan.nextInt();
			boolean repeat = gameControler.checkUnRepeatedEnemy(eNName, eNLvl-1);
			if (repeat) {
				modLvl = true;
			}else {
				System.out.print("\nThis Enemy is already registered in this level, Please type another");
			}
		}

		if (gameControler.addEnemyToLevel(eNName,eNLvl-1)) {
			System.out.println("Enemy successfully added");
		} else {
			System.out.println("Failed to add Enemy");
		}
	}

    /**Description: This method counts the amount of treasures
     * and enemies in a certain level that the user decides
	 * @return void. The amount of treasures and enemies in a certain level
	 */	
	private static void checkLvl(){
		System.out.println("Type the Level you want to check the Treasures and Enemies (1-10)");
		int objLvl = scan.nextInt();

		System.out.print(gameControler.showObjinLvl(objLvl));	
	}

    /**Description: This method counts the amount of treasures 
     * with the same name in all levels
	 * @return void. The amount of treasures with the same name in all levels
	 */	
	private static  void searchTreasInAllLvl(){
		scan.nextLine();

		boolean modTR = false;
		String tRName = "";

		while (!modTR) {

			System.out.println("Type Treasure's Name");
			tRName = scan.nextLine();

			boolean existence = gameControler.checkTreasureNameExistence(tRName);

			if (existence) {
				modTR = true;
			}else {
				System.out.print("\nThis Treasure does not exist, Please type another");
			}
		}
		System.out.println(gameControler.searchTreasinLvl(tRName));
	}

	public static void main(String[] args) {

		vdConfig();
	}
}