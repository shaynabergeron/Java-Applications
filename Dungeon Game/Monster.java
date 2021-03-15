//Monster class for HW 6
//Author: Shayna Bergeron
//Date: 7/23/2018

import java.util.Random;

public class Monster extends GameCharacter{
	private Random randomMonster = new Random();
	public final int GOBLIN = 0;
	public final int TROLL = 1;
	public final int DRAGON = 2;
	private Weapon mainItem;

	/*constructor*/
	public Monster(){
		super();
		generateMonster();
	}
	/*creating the goblin*/
	public void createGoblin(){
		super.name = "GOBLIN";
		super.attackPower = 4 + randomMonster.nextInt(2);
		super.health = 50 + randomMonster.nextInt(20);
		super.isFighting = true;
		mainItem = null;
	}
	/*creating the troll*/
	 public void createTroll(){
        super.name = "TROLL";
        super.attackPower = 10 + randomMonster.nextInt(4);
        super.health = 65 + randomMonster.nextInt(20);
        super.isFighting = true;
         mainItem = null;
   }
   /*creating the dragon*/
   public void createDragon(){
        super.name = "DRAGON";
        super.attackPower = 20 + randomMonster.nextInt(2);
        super.health = 75 + randomMonster.nextInt(20);
        super.isFighting = true;
        mainItem = new Weapon("sword");
        if(super.health < 0 ){
             System.out.printf("You picked up a %s and killed the monster.",mainItem);
        }//end of if statement for sword
    }
    /*monster generator*/
    public void generateMonster(){
        int randomNumber = randomMonster.nextInt(3);
        
        if (randomNumber == GOBLIN){
            createGoblin();
        }
        else if (randomNumber == TROLL){
            createTroll();
        }
        else if (randomNumber == DRAGON){
            createDragon();
        }
    }
    /*drop weapon method*/
    public Weapon dropWeapon(){
        return this.mainItem;
    }
    /*take turn*/
    public void takeTurn(GameCharacter player){
        super.attack(player);
    }

}// end of monster class