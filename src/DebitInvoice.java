import java.util.List;

public class DebitInvoice extends Invoice {

    private List<Item> items;
    private Discount discount;

    public DebitInvoice(String number, List<Item> items, Discount discount)throws InvoiceNumberTooLongException{
        super(number);
        this.items = items;// class field and constructor's 2-nd parameter have the same name :
                                       // 'this' means that we are refering to the field of this particular instance (object)
                                       // 'this.amountToPay' means 'private final double amountToPay'; and 'amountToPay' means 2-nd parameter

        setDiscount(discount);
    }

    public DebitInvoice(String number, List<Item> items) throws InvoiceNumberTooLongException {
        this(number, items, Discount.NO_DISCOUNT);   // A call to the upper constructor
    }


    public void setDiscount(Discount discount){
        this.discount = discount;
    }

    @Override
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
