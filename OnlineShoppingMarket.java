import java.util.ArrayList;
import java.util.HashMap;

public class OnlineShoppingMarket {
    private ArrayList<Product> allProducts = new ArrayList<Product>();
    private ArrayList<Customer> allCustomers = new ArrayList<Customer>();
    private ArrayList<Sale> allSales = new ArrayList<Sale>(); //This attribute will be used to generate bills.

    public OnlineShoppingMarket(String priceList,String shoppingList){
        //We will construct our system according to the priceList.txt and shoppingList.txt.
        //You can assume that arguments of this function are the database of this system.
        FileReader fileReader = new FileReader();
        String lines1[] = fileReader.ReadFile(priceList);
        String lines2[] = fileReader.ReadFile(shoppingList);
        //Firstly,we will create the products and add their price policies.
        for(String line : lines1)
        {
            String splitLine[] = line.split("\\s+"); // \\s+ means all whitespaces.
            boolean existence = false; //If a product already exists in the system,we do not need to create a new one.
            for(Product p : this.allProducts){
                if(p.getName().equals(splitLine[0]))
                {   //If we already have this product,we just have to add a new price policy.
                    p.addPricePolicy(splitLine[1],splitLine[2],splitLine[3],splitLine[4]);
                    existence = true;
                    break;
                }
            }
            if(!existence){
                //Now we can create a new product.
                Product newProduct = new Product(splitLine[0]);
                newProduct.addPricePolicy(splitLine[1],splitLine[2],splitLine[3],splitLine[4]);
                allProducts.add(newProduct);
            }
            //Products are ready.
        }
        //Now we will create active customers and sales.
        for(String line : lines2){
            String splitLine[] = line.split("\\s+");
            boolean existence = false; // Same steps as beyond algorithm.
            for(Customer c : this.allCustomers){
                boolean control1 = c.getName().equals(splitLine[0]);
                boolean control2 = c.getSurname().equals(splitLine[1]);
                if(control1&&control2){
                    //If this customer is already in the system,we only need to add a new purchase to him/her.
                    existence = true;
                    HashMap<Product,Integer> purchasedProducts = new HashMap<Product,Integer>();
                    for(int i=4;i< splitLine.length;i+=2){
                        String productName = splitLine[i];
                        for(Product p : this.allProducts ){
                            if(p.getName().equals(productName)){
                                purchasedProducts.put(p,Integer.parseInt(splitLine[i+1]));
                            }
                        }
                    }
                    Purchase newPurchase = new Purchase(splitLine[3],splitLine[2],purchasedProducts);
                    //After purchase is completed,we need to store it as a sale in the system.
                    this.allSales.add(new Sale(c.getName()+" "+c.getSurname(),newPurchase));
                    c.addPurchase(newPurchase);
                }
            }
            if(!existence){
                //If this customer does not exist in the system,that means we need to create a new customer and a purchase.
                Customer newCustomer = new Customer(splitLine[0],splitLine[1],splitLine[2]);
                HashMap<Product,Integer> purchasedProducts = new HashMap<Product,Integer>();
                for(int i=4;i< splitLine.length;i+=2){
                    String productName = splitLine[i];
                    for(Product p : this.allProducts ){
                        if(p.getName().equals(productName)){
                            purchasedProducts.put(p,Integer.parseInt(splitLine[i+1]));
                        }
                    }
                }
                Purchase newPurchase = new Purchase(splitLine[3],splitLine[2],purchasedProducts);
                this.allSales.add(new Sale(newCustomer.getName()+" "+newCustomer.getSurname(),newPurchase));
                newCustomer.addPurchase(newPurchase);
                allCustomers.add(newCustomer); //The only difference between beyond algorithm this line.
                //We have to add a customer to the system if he/she is newly created.
            }
        }
    }
    public void displayBills(){
        //In this assignment,we have to print all sales to the screen.
        for(Sale s : allSales){
            s.generateBill();
        }
    }


}
