import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private String name;
    private String surname;
    private String typeOfMembership;
    private ArrayList<Purchase> purchases = new ArrayList<Purchase>(); //Customer HAS A purchase or purchases.

    public Customer(String name,String surname,String typeOfMembership){
        //Customer objects do not need to have purchases.
        this.name = name;
        this.surname = surname;
        this.typeOfMembership = typeOfMembership;
    }
    public void addPurchase(Purchase newPurchase){
        //If a customer buys something,we will add corresponding object by using this function.
        purchases.add(newPurchase);
    }
    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTypeOfMembership() {
        return typeOfMembership;
    }

    public void setTypeOfMembership(String typeOfMembership) {
        this.typeOfMembership = typeOfMembership;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }
}
