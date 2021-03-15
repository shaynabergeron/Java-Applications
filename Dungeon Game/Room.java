//Room class for HW 6
//Shayna Bergeron	
//  7/24/2018

import java.util.Random; //importing things

public class Room {
    /*declaring things*/
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String descirption;
    private Potion mainItem;
    private Monster newMonster;
    
    /*constructing things*/
    public Room(String descirption){        
        this.descirption = descirption;
        assignItems();
        randomMonster();
    }
    /*monster generator*/
    public void randomMonster(){
        Random randomMonster = new Random();
        int randomNumber = randomMonster.nextInt(4);
        if(randomNumber == 0){
            newMonster = null;
        }
        else if (randomNumber == 1){
            newMonster = new Monster();
        }
        else if (randomNumber == 2){
            newMonster = new Monster();
        }
        else if (randomNumber == 3){
            newMonster = new Monster();
        }
    }
    /*assigning items*/
    public void assignItems(){
        Random randomItem = new Random();
        int randomNumber = randomItem.nextInt(2);
        if(randomNumber == 0){
            mainItem = null;
        }
        else if (randomNumber == 1){
            mainItem = new Potion();
        }    
    }
    /*direction and room setters*/
    public void setNorth(Room north){
        this.north = north;
    }
    
    public void setSouth(Room south){
        this.south = south;
    }
    
    public void setEast(Room east){
        this.east = east;
    }
    
    public void setWest(Room west){
        this.west = west;
    }
    /*getters for directions*/
    public Room getNorth(){
        return this.north;
    }
    
     public Room getSouth(){
        return this.south;
    }
    
     public Room getEast(){
       return this.east;
    }
    
     public Room getWest(){
        return this.west;
    }
    
     public String getDescription()
    {
       return descirption;
    }
    /*setting exists for rooms constructor*/
    public void setExits(Room north,Room south,Room east, Room west){
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }
    
    public String getExits(){
        String exits = "\nSelect n for north||s for south||e for east||w for west||q to quit\n\nYou can head:";
        if (this.north != null){
            exits = exits.concat(" north");
        }
        
         if (this.south != null){
            exits += " south";
        }
        
         if (this.east != null){
            exits += " east";
        }
         if (this.west != null){
            exits += " west";
        }
        return exits;
    }
    /*setting items*/
    public void setItem(Potion givenItem){
        mainItem = givenItem;
    }
    public Potion getItem(){
        return mainItem;
    }
    public Monster getMonster(){
        return newMonster;
    }
    public void setMonster(Monster newMonster){
        this.newMonster = newMonster;
    }
    public boolean checkForMonster(){
        if(newMonster != null){
            return true;
        }
        else{
            return false;
        }
    }
    /*to string*/
    public String toString(){
        if(checkForMonster() == true){
            if(mainItem != null){
                 return String.format("%s\n%s\nItem: %s",getExits(),getDescription(), mainItem);
            }
            else {
            return String.format("%s\n%s\n",getExits(),getDescription() );
            }
        }
        else{
            if(mainItem != null){
                 return String.format("%s\n%s\nLooks like you found something! %s",getExits(),getDescription(), mainItem.toString() );
            }
            else{
            return String.format("%s\n%s\n",getExits(),getDescription() );
            }
        }
    }
}//end of room class
