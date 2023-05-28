import java.util.ArrayList;

public class Product {
    private String name; //Sweater,jeans,hat......
    //Each product in our system will have multiple prices.
    private ArrayList<PricePolicy> allPrices = new ArrayList<PricePolicy>();

    public Product(String name)
    {   //Firstly,we will create products by using this constructor and then add corresponding price policies.
        this.name = name;
    }
    public void addPricePolicy(String typeOfMembership,String startDate,String endDate,String price){
        // After we read priceList.txt file,we will create our products and their price policies.
        allPrices.add(new PricePolicy(price,startDate,endDate,typeOfMembership));
    }
    public double getUnitPrice(String typeOfMembership,String shoppingDate)
    {   //This function checks all price policies of a specific product and return the unit price according to the arguments.
        String splitDate[] = shoppingDate.split("\\.");
        int totalDays = Integer.parseInt(splitDate[0]) + Integer.parseInt(splitDate[1])*30
                        + Integer.parseInt(splitDate[2])*360;
        double unitPrice = 0d;
        for(PricePolicy p : this.allPrices){
            //This loop will traverse price policies one by one and stops when it finds the correct price.
            boolean control1 = p.getValidMembership().equals(typeOfMembership);
            boolean control2 = p.getStartDate()<= totalDays && totalDays<=p.getEndDate();
            if(control1 && control2){
                unitPrice = p.getPrice();
                break;
            }
        }
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PricePolicy> getAllPrices() {
        return allPrices;
    }

    public void setAllPrices(ArrayList<PricePolicy> allPrices) {
        this.allPrices = allPrices;
    }
}
