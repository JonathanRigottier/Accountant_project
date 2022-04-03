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
        Invoice invoice1 = new Invoice("ABC-0001", items1);

        List<Item> items2 = new ArrayList<>();
        items2.add(table);
        items2.add(tv);
        items2.add(laptop);
        Invoice invoice2 = new Invoice("ABC-00021952952929", items2, Discount.TEN_PERCENT);

        List<Item> items3 = new ArrayList<>();
        items3.add(smartphone);
        Invoice invoice3 = new Invoice("ABC-151961665166515615", items3, Discount.TWENTY_FIVE_PERCENT);

        List<Item> items4 = new ArrayList<>();
        items4.add(table);
        items4.add(table);
        items4.add(table);
        items4.add(laptop);
        items4.add(laptop);
        Invoice invoice4 = new Invoice("ABC-151", items4, Discount.FIFTY_PERCENT);

        System.out.println("Invoice 1 : " + invoice1.getNumber() + ", amount = " + invoice1.getAmountToPay());
        System.out.println("Invoice 2 : " + invoice2.getNumber() + ", amount = " + invoice2.getAmountToPay());
        System.out.println("Invoice 3 : " + invoice3.getNumber() + ", amount = " + invoice3.getAmountToPay());
        System.out.println("Invoice 4 : " + invoice4.getNumber() + ", amount = " + invoice4.getAmountToPay());
    }
}
