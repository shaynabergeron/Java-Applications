//Item class for HW 6
//Author: Shayna Bergeron
//Date: 7/23/2018

public abstract class Item{
    private String mainItem;
    /*constructor*/
    public Item(String giveItem){
        this.mainItem = giveItem;
    }
    /*item tostring*/
    public String toString(){
        if(mainItem == null){
            return "No item";
        }
        else{
            return mainItem;
        }
    }
}//end of item class
