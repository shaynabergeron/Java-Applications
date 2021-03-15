//Game Application of HW 6
//Author: Shayna Bergeron	
//Date: 7/25/2018

import java.util.Scanner;

public class GameApp{
	/*declarations*/
    private static boolean gameOver = false;
    private static boolean checkInventory;
    static Player newPlayer = new Player("hero", 100, 40, 20, 1); 
    static Dungeon newDungeon = new Dungeon();
    static Room currentRoom = newDungeon.getRoom0();
    private static String userInput;
    static Scanner input= new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.println("You are walking down some creepy street and start to get an eerie feeling. You decide to take a right to another street. You see a long dark alley and decide to head down it...");
        System.out.print(currentRoom);
        while (gameOver == false){
            if (currentRoom.getItem() != null){
                System.out.println("\nWould you like to pick up the item? Y or N");
                
                userInput= input.next();
               
                if(userInput.equals("Y") || userInput.equals("y")){
                    newPlayer.pickPotion(currentRoom.getItem() );
                    currentRoom.setItem(null);
                }
                else if(userInput.equals("N") || userInput.equals("n")){
                    System.out.println("\nYou choose not to pick up potion.");
                }
                else{
                    System.out.println("Invalid selection");
                }
            }//end of if
            
            if(currentRoom.checkForMonster()== true){
                System.out.println(currentRoom.getMonster());
                userMenu();
            } 
            else {
                currentRoom = executeUserChoice(); 
            }
        }//end of while
    }//end of main
    
    /*loop for combat*/
    public static void combatLoop(){
            Monster newMonster1 = currentRoom.getMonster();
            while (newPlayer.isAlive() == true && newMonster1.isAlive() == true){
            System.out.printf("Your health: %d\nYour attack power: %d\nTheir health: %d\nTheir Attack Power: %d\n",newPlayer.health,newPlayer.attackPower,newMonster1.health,newMonster1.attackPower);
            newPlayer.takeTurn(newMonster1);
            newMonster1.takeTurn(newPlayer);
            }
         
         if (newPlayer.isAlive() == false){
                    System.out.println("You died.");
                    System.exit(000);
                 }
        else if(newMonster1.isAlive() == false){
            System.out.println("You won the fight!");
            currentRoom.setMonster(null);
        }   
    }//end of combat loop
    
    public static void userMenu(){
        System.out.println("\nPress 'F' to fight back or press 'N' to go to the next room. Or press 'I' to check inventory. You can use potions if you check inventory.");
        userInput= input.next();
        if(userInput.equals("F") || userInput.equals("f")){
            combatLoop();
        }
        else if(userInput.equals("N") || userInput.equals("n") ){
            //currentRoom.toString();
            //System.out.print(currentRoom);
            executeUserChoice();
        }
         else if(userInput.equals("I") || userInput.equals("i") ){
                 if(newPlayer.checkInventory() == true ){
                     System.out.println(newPlayer.getInventory() );
                        if(newPlayer.checkPotion() == true){
                        System.out.println("\nThere is a potion in this room. Do you want to use the potion? It will boost your health. Y or N");
                        userInput = input.next();
                        
                                 if(userInput.equals("Y") || userInput.equals("y")){
                                     newPlayer.usePotion();
                                 }
                      }
                }
       
            System.out.println("\nPress 'F' to fight back or press 'N' to go to the next room. Or press 'I' to check inventory.");
        } 
    }
    
    public static Room executeUserChoice(){
        System.out.println(currentRoom);
        Room nextRoom = currentRoom;
        userInput= input.next();
        if (userInput.equals("N") || userInput.equals("n")){
            nextRoom = currentRoom.getNorth();
        }
        else if (userInput.equals("S") || userInput.equals("s")){
            nextRoom = currentRoom.getSouth();
        }
        else if (userInput.equals("E") || userInput.equals("e")){
            nextRoom = currentRoom.getEast();
        }
        else if (userInput.equals("W") || userInput.equals("w")){
            nextRoom = currentRoom.getWest();
        }
       else if (userInput.equals("Q") || userInput.equals("q")){
            System.out.println("This place is too strange, you decide to leave.");
            gameOver= true;
        }
        if (nextRoom == null){
            System.out.println("\nYou can't go that way.");
            nextRoom = currentRoom;
        }
         return nextRoom;
    }
}//end of Game Application
