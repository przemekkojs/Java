package Processors;

public class Constants 
{
	//Blocks
	public static final char SCENE_BLOCK = 'X';
	public static final char HOUSE_BLOCK = 'H';	
	public static final char FOOD_BLOCK = '.';
	
	//Bodies
	public static final char MEDKIT_BODY = 'M';
	public static final char ITEM_BODY = 'I';
	public static final char PLAYER_BODY = 'P';
	public static final char ENEMY_BODY = 'E';
	
	//Files
	public static final String MAIN_MAP_FILE = "MainMap.txt";
	public static final String GAME_SAVE_FILE = "Game.txt";
	public static final String LOGS_FILE = "Logs.txt";
	
	//Values
	public static final int MAX_HEALTH = 100;
	public static final int MAX_ENEMY_HEALTH = 25;
	
	public static final int MAX_FOOD = 10;
	public static final int INVENTORY_SIZE = 4;
	public static final int MEDKITS_AT_BEGIN = 3;
	
	public static final int ENEMIES_AT_HOUSE = 1;
	public static final int ENEMIES_AT_MAP = 3;
	
	//UI
	public static final int UI_BUTTON_SIZE = 35;
	public static final int UI_GAP = 10;
	public static final int UI_FONT_SIZE = 15;
	public static final String UI_FONT = "Consolas";
	
	//Entities
	public static final String ENTITY = "Entity";
	public static final String PLAYER = "Player";
	
	//Announcements
	public static final String LOADING_MAP = "Loading map...";
	public static final String LOADING_PLAYER = "Loading player...";
	public static final String LOADING_ENEMIES = "Loading enemies...";	
	public static final String PLAYER_LOADED_SUCCESS = "Player loaded successfully.";
	public static final String MAP_LOADED_SUCCESS = "Map loaded successfully.";
	public static final String ENEMIES_LOADED_SUCCESS = "Enemies loaded successfully.";
	public static final String NO_MEDKITS_LEFT = "No medkits left!";
	
	//Game
	public static final String GAME_EXIT = "Exiting game...";	
	public static final String GAME_SAVE = "Saving game...";
	
	//Errors
	public static final String ERR_LOADING_MAP = "Error: Map loading.";
	public static final String ERR_FILE_NOT_FOUND = "Error: Map data not found.";
	public static final String ERR_CLOSE = "Error: Map loading terminated.";
	public static final String ERR_SAVE = "Error: Game saving.";
}
