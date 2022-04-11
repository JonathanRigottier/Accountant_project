


public class InvoiceNumberTooLongException extends Exception{

    public InvoiceNumberTooLongException(String originalInvoiceNumber){
        super("Invoice number " + originalInvoiceNumber +
                " is too long, thus such invoice would not be registered in the system! " +
                "Please enter a valid number !");
    }
}
