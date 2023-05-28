
public class Main {
    public static void main(String[] args) {
        /*This program represents a basic Online Shopping Market System.It takes 2 inputs
        from command line(shoppingList.txt,priceList.txt) and creates the system according to
        the priceList.txt.After creation is completed,system starts working and generates outputs
        according to the shoppingList.txt.*/
	    String shoppingList = args[0];
        String priceList = args[1];
        OnlineShoppingMarket osm = new OnlineShoppingMarket(priceList,shoppingList);
        osm.displayBills();
    }
}
