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
	
	//Paths
	public static final String MAIN_MAP_FILE = "MainMap.txt";
	
	//Values
	public static final int MAX_HEALTH = 100;
	public static final int MAX_ENEMY_HEALTH = 25;
	
	public static final int MAX_FOOD = 10;
	public static final int INVENTORY_SIZE = 4;
	public static final int MEDKITS_AT_BEGIN = 3;
	
	public static final int ENEMIES_AT_HOUSE = 4;
	public static final int ENEMIES_AT_MAP = 20;
	
	//Entities
	public static final String ENTITY = "Entity";
	public static final String PLAYER = "Player";
	
	//Announcements
	public static final String LOADING_MAP = "Loading map...";
	public static final String LOADING_PLAYER = "Loading player...";
	public static final String PLAYER_LOADED_SUCCESS = "Player loaded successfully.";
	public static final String MAP_LOADED_SUCCESS = "Map loaded successfully.";
	public static final String NO_MEDKITS_LEFT = "No medkits left";
	
	//Errors
	public static final String ERR_LOADING_MAP = "Error: Map loading.";
}
