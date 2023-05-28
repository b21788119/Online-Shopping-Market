public class PricePolicy {
    //All products in the system will have multiple price policies.We will store them in an arrayList.
    private double price;
    private int startDate = 0; //Prices will only be available between start date and end date.
    private int endDate = 0;
    private String validMembership; //Prices will vary according to the membership type of a user.

    public PricePolicy(String price,String firstDate,String finalDate,String validMembership){
        this.price = Double.parseDouble(price);
        /*firsDate and finalDate will be like  day.month.year therefore,we have to split
        these forms first and then convert them into days.*/
        String splitDate1[] = firstDate.split("\\.");
        String splitDate2[] = finalDate.split("\\.");
        //Assume that a month consists of 30 days and a year consists of 360 days.
        this.startDate = Integer.parseInt(splitDate1[0]) + Integer.parseInt(splitDate1[1])*30 +
                    Integer.parseInt(splitDate1[2])*360;
        this.endDate = Integer.parseInt(splitDate2[0]) + Integer.parseInt(splitDate2[1])*30 +
                Integer.parseInt(splitDate2[2])*360;
        this.validMembership = validMembership;
    }
    //Getters and setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public String getValidMembership() {
        return validMembership;
    }

    public void setValidMembership(String validMembership) {
        this.validMembership = validMembership;
    }
}
