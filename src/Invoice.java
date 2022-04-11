public abstract class Invoice {

    private String number;

    protected Invoice (String number) throws InvoiceNumberTooLongException {
        setNumber(number);
    }

    public String getNumber () {
        return number;
    }

    public void setNumber(String number) throws InvoiceNumberTooLongException{
        // Check whether invoice number length is less than 10 symbols. Otherwise cut it to 10 symbols:
        if(number.length() > 10 ){
            throw new InvoiceNumberTooLongException(number);
        }
        // And then assign the final value of invoice number to the instance's field
        this.number = number;
    }

    public abstract double getAmountToPay () throws DiscountIsInvalid ;

}
