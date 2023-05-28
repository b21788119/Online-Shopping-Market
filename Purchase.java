import java.util.HashMap;

public class Purchase {
    //Each available customer in our system will have purchases separated by their dates.
    private String shoppingDate;
    private String typeOfMembership;
    private String document = ""; //This attribute will be helpful when we create the bill.
    private double totalCost; //This attribute will store the total cost of a purchase.
    public Purchase(String shoppingDate, String typeOfMembership, HashMap<Product,Integer> pp){
        this.shoppingDate = shoppingDate;
        this.typeOfMembership = typeOfMembership;
        for(Product p : pp.keySet()){
            String productName = p.getName();
            double unitPrice = p.getUnitPrice(typeOfMembership,shoppingDate);
            int quantity = pp.get(p); //pp means purchased products.
            double total = unitPrice*quantity; //Updates the total cost.
            this.totalCost+=total;
            this.document+=productName+"\t"+unitPrice+"\t"+quantity+"\t"+total+"\n";
        }
    }
    // Getters and setters
    public String getShoppingDate() {
        return shoppingDate;
    }

    public void setShoppingDate(String shoppingDate) {
        this.shoppingDate = shoppingDate;
    }

    public String getTypeOfMembership() {
        return typeOfMembership;
    }

    public void setTypeOfMembership(String typeOfMembership) {
        this.typeOfMembership = typeOfMembership;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
