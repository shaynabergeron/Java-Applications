//Game Chracter class for HW 6
//Author: Shayna Bergeron
//Date: 7/22/2018

public abstract class GameCharacter{
	protected String name;
	protected int health; 
	protected int attackPower;
	protected boolean isFighting;

	public GameCharacter(){
		name="";
		health = 0;
		attackPower = 0;
		isFighting = false;
	}
	/*constructor*/
	public GameCharacter(String name, int health, int attackPower){
		this.name = name;
		this.health = health;
		this.attackPower = attackPower;
	}//end of constructor
	/*start of getters*/
	public int getHealth(){
		return this.health;
	}//end of getter for health

	public String getName(){
		return this.name;
	}//end of getter for name

	public int attackPower(){
		return this.attackPower;
	}//end of attack power getter

	public boolean isFighting(){
		return this.isFighting;
	}//end of isfightong getter
	/*start of setters*/
	public void setHealth(int health){
		this.health = health;
	}//end of setter for health

	public void setName(String name){
		this.name = name;
	}//end of name setter

	public void setAttackPower(int attackPower){
		this.attackPower = attackPower;
	}//end of attack setter

	public void setIsFighting(boolean isFighting){
		this.isFighting = isFighting;
	}//end of is fighting setter
	/*creation of methods*/
	public void attack(GameCharacter fighting){
		fighting.setHealth(fighting.getHealth() - this.attackPower);
	}

	public boolean isAlive(){
		if(this.health > 0){
			return true;
		}
		else return false;
	}//is alive method
	@Override
	public String toString(){
		return "You are fighting "+this.name+" Health: "+this.health+" Attack Power: "+this.attackPower;
	}//end of tostring
	/*abstract method for taking turn*/
	public abstract void takeTurn(GameCharacter opponent);
}//end of class