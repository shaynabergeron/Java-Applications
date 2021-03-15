//Dungeon class HW 6
//Shayna Bergeron
// 7/24/2018

public class Dungeon {
    private Room alley;
    private Room courtyard;
    private Room mainRoom;
    private Room bathRoom;
    private Room hiddenRoom;
    
    /*dungeon constructor*/
    public Dungeon(){
       /*room descriptions*/
       alley = new Room("\nYou are in a dark alley-way. The walls and the floor are made out of cobblestone.");
       courtyard = new Room("\nYou are in a courtyard. There are trees everywhere blocking out your view.");
       mainRoom = new Room("\nYou are in an abonded and haunted bar room.");
       bathRoom = new Room("\nYou are in the bathroom.");
       hiddenRoom = new Room("\nYou found the hidden room. There are blood stains on the floor and walls.");
       
       /*setting up the navigation*/
       this.alley.setNorth(courtyard);
       this.courtyard.setNorth(mainRoom);
       this.courtyard.setSouth(alley);
       this.mainRoom.setWest(bathRoom);
       this.mainRoom.setSouth(courtyard);
       this.bathRoom.setEast(mainRoom);
       this.bathRoom.setSouth(hiddenRoom);
       this.hiddenRoom.setNorth(bathRoom);     
    }
    
    public Room getRoom0(){
        return this.alley;
    }
    
    public boolean hiddenRoomCheck(Room currentRoom){
        boolean hiddenRoomChecked = false;
        if (hiddenRoom.equals(currentRoom)){
            hiddenRoomChecked = true;
        }
        return hiddenRoomChecked;
    }
    
    public boolean mainRoomCheck(Room currentRoom){
        boolean mainRoomChecked = false;
        if (mainRoom.equals(currentRoom)){
            mainRoomChecked = true;
        }
        return mainRoomChecked;
    }    
}//end of dunegon class
