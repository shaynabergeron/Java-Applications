//Player class for HW 6
//Author: Shayna Bergeron
//Date: 7/23/2018

/*importing stuff*/
import java.util.Scanner;
import java.util.ArrayList;

public class Player extends GameCharacter{
	private int playerMana;
	private int playerLevel;
	ArrayList<Potion> potions = new ArrayList<Potion>();
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private static int userInput;
	static Scanner input = new Scanner(System.in);

	/*constructor*/
	public Player(String playerName, int playerHealth, int playerAttackPower, int playerMana, int playerLevel){
		super(playerName, playerHealth, playerAttackPower);
		this.playerLevel = playerLevel;
		this.playerMana = playerMana;
	}//end of constructor
	/*getters & setters*/
	public int getMana(){
		return playerMana;
	}//getter for mana

	public int getLevel(){
		return playerLevel;
	}//getter for level

	public void setMana(int mana){
		this.playerMana = mana;
	}//setter for mana

	public void setLevel(int level){
		this.playerLevel = level;
	}//setter for  level
	/*method for take turn*/
	public void takeTurn(GameCharacter monster){
		System.out.println("1. Cast a glare 2. Punch");
		userInput = input.nextInt();
		if(userInput == 1){
			monster.health -= 20;
		}
		else if(userInput == 2){
			super.attack(monster);
		}
		else if(monster.health < 0){
			System.out.println("You beat the monster!!!");
		}
	}//end of take turn method
	/*method for picking up weapons*/
	public void pickWeapon(Weapon weapon){
		weapons.add(weapon);
	}
	/*picking up potions*/
	public void pickPotion(Potion potion){
		potions.add(potion);
	}
	/*using the potions*/
	public void usePotion(){
		if(checkPotion() == true){
			super.health += super.health/2;
			potions.remove(0);
		}
	}
	/*check potion*/
	public boolean checkPotion(){
		if(potions.size() > 0){
			return true;
		}
		else{
			return false;
		}
	}
	/*check weapon*/
	public boolean checkWeapon(){
        if(weapons.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    /*check invetory*/
    public boolean checkInventory(){
        if(weapons.size() > 0 || potions.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    /*getter for invetory*/
    public String getInventory(){
        String inventory = "";
        if (potions.size() > 0){
            inventory += "You have this many potions:\n";
            for(int i = 0; potions.size() > i; i++){
                inventory += potions.get(i).toString() + " ";
            }
        }
        
        if (weapons.size() > 0){
            inventory += "You have the following weapons:\n";
            for(int i = 0; weapons.size() > i; i++){
                inventory += weapons.get(i).toString() + " ";
            }
        }
        return inventory;
    }//end of get inventory
}//end of Player class