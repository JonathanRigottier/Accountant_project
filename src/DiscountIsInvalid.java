public class DiscountIsInvalid extends Exception {

    public DiscountIsInvalid(String discountPercentage){
        super("The discount entered " + discountPercentage + " is invalid." +
                " Please enter a number between 0.0 (0% discount) and 1.0 (100% discount)");
    }
}
