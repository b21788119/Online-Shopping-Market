
public class Sale {
    //This class is for tracking all sales and generating bills.
    private String customerName; //Customer name is necessary.
    private Purchase purchase; //Each purchase in the system means a sale for the system.

    public Sale(String customerName, Purchase purchase) {
        this.customerName = customerName;
        this.purchase = purchase;
    }
    public void generateBill(){
        System.out.println("---"+customerName+"---");
        System.out.print(purchase.getDocument());
        System.out.println("Total "+purchase.getTotalCost());
    }
}
