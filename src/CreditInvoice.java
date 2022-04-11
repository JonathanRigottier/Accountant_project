import java.util.List;

public class CreditInvoice extends Invoice {

    private DebitInvoice debitInvoice;

    public CreditInvoice(String number, DebitInvoice debitInvoice) throws InvoiceNumberTooLongException {
        super(number);
        this.debitInvoice = debitInvoice;
    }

    @Override
    public double getAmountToPay() throws DiscountIsInvalid {
        return debitInvoice.getAmountToPay() * -1;
    }

}
