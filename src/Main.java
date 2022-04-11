import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Create items
        //    - Name
        //    - Description
        //    - Price
        //    - ....
        // 2. Create different combinations of those items
        // 3. Pass those combinations to different invoices
        // 4. Invoice should be able to handle such a combination § calculate total price (inside getAmountToPay)

        // Items that are available in our system for accountant to select for any particular invoice :
        // We imagine, that those are somehow entered in the system (not a concern of this example):
        Item table = new Item("Table","White kitchen table with 3 legs", 49.99);
        Item tv = new Item("TV","Modern 53\" TV set", 300.0);
        Item laptop = new Item("Laptop","i7, 16 GB RAM, 500 GB SSD",800.0);
        Item smartphone = new Item("Smartphone","Dual-sim mobile phone", 129.99);


        // invoice1 would be issued for a tv and a smartphone

        // interface Collection
        // |-- interface List
        //     |-- class ArrayList
        //     |-- class LinkedList
        // |-- interface Set
        //     |-- class HashSet
        //     |-- class LinkedHashSet
        //     |-- class TreeSet
        // |-- interface Map
        //     |-- class HashMap
        //     |-- class LinkedHashMap
        //     |-- class TreeSet

        // We pass a List of items (that we imagine were selected by accountant) to each invoice as a second parameter of a constructor

        List<Item> items1 = new ArrayList<>();
        items1.add(tv);
        items1.add(tv);
        items1.add(smartphone);
        try {
            Invoice debitInvoice1 = new DebitInvoice("ABC-0001", items1);
            System.out.println("Invoice 1 : " + debitInvoice1.getNumber() + ", amount = " + debitInvoice1.getAmountToPay());
        } catch (InvoiceNumberTooLongException | DiscountIsInvalid e){
            System.out.println(e.getMessage());
        }

        List<Item> items2 = new ArrayList<>();
        items2.add(table);
        items2.add(tv);
        items2.add(laptop);
        try {
            Invoice debitInvoice2 = new DebitInvoice("ABC-00021952952929", items2, Discount.SIXTY_PERCENT);
            System.out.println("Invoice 2 : " + debitInvoice2.getNumber() + ", amount = " + debitInvoice2.getAmountToPay());
        } catch (InvoiceNumberTooLongException | DiscountIsInvalid e){
            System.out.println(e.getMessage());
        }

        List<Item> items3 = new ArrayList<>();
        items3.add(smartphone);
        try {
            Invoice debitInvoice3 = new DebitInvoice("ABC-151961665166515615", items3, Discount.TWENTY_FIVE_PERCENT);
            System.out.println("Invoice 3 : " + debitInvoice3.getNumber() + ", amount = " + debitInvoice3.getAmountToPay());
        } catch (InvoiceNumberTooLongException | DiscountIsInvalid e){
            System.out.println(e.getMessage());
        }

        List<Item> items4 = new ArrayList<>();
        items4.add(table);
        items4.add(table);
        items4.add(table);
        items4.add(laptop);
        items4.add(laptop);
        try {
            DebitInvoice debitInvoice4 = new DebitInvoice("ABC-151", items4, Discount.FIFTY_PERCENT);
            System.out.println("Invoice 4 : " + debitInvoice4.getNumber() + ", amount = " + debitInvoice4.getAmountToPay());

            Invoice creditInvoice4 = new CreditInvoice("CRE-0001", debitInvoice4);
            System.out.println("creditInvoice 4 : " + creditInvoice4.getNumber() + ", amount = " + creditInvoice4.getAmountToPay());
        } catch (InvoiceNumberTooLongException | DiscountIsInvalid e){
            System.out.println(e.getMessage());
        }

    }
}
