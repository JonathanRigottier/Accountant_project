import java.util.List;

public class Invoice {

    private String number;
    private List<Item> items; // Encapsulation : this value is not exposed to other classes (not even through a public method)
    private Discount discount;

    public Invoice(String number, List<Item> items, Discount discount) {
        setNumber(number);
        this.items = items;// class field and constructor's 2-nd parameter have the same name :
                                       // 'this' means that we are refering to the field of this particular instance (object)
                                       // 'this.amountToPay' means 'private final double amountToPay'; and 'amountToPay' means 2-nd parameter

        setDiscount(discount);
    }

    public Invoice(String number, List<Item> items){
        this(number, items, Discount.NO_DISCOUNT);   // A call to the upper constructor
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String number) {
        // Check whether invoice number length is less than 10 symbols. Otherwise cut it to 10 symbols:
        if(number.length() > 10 ){
            number = number.substring(0,10);
        }
        // And then assign the final value of invoice number to the instance's field
        this.number = number;
    }

    public void setDiscount(Discount discount){
        this.discount = discount;
    }


    public double getAmountToPay(){
        double totalPrice = calculateTotalPrice();
        return totalPrice - totalPrice * discount.getPercentage();
    }

    private double calculateTotalPrice(){
        double totalPrice = 0.0;
        for(Item currentItem : items){
            totalPrice += currentItem.getPrice();
        }
        return totalPrice;
    }

}
