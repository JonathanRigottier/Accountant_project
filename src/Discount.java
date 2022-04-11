

public enum Discount {
    // These are enum elements, that by themselves mean nothing to Java
        NO_DISCOUNT(0.0),
        FIVE_PERCENT(0.05),     // For every element of the enum we call its constructor passing the value of 'double percentage' parameter
        TEN_PERCENT(0.1),
        TWENTY_FIVE_PERCENT(0.25),
        FIFTY_PERCENT(0.5),
        SIXTY_PERCENT(-0.6);

    // After elements (;) we can define the same things that we can do in an ordinary class.
    // Those things would be individual to every element of this enum. IT's like each element of the enum is "kind of like" an instance of it.

    // Let's store a double value of a percentage for each element of this enum :
    private double percentage; // Each of enum's elements would have its own value for this field.

    // A constructor of an enum CANNOT be public because we do not create instances of an enum outside the enum itself.
    // A constructor calls are performed upon each of the enum's elements inside this same enum.
    // Because this is how Java is designed
    Discount(double percentage) throws DiscountIsInvalid {
        setDiscount (percentage);
    }

    // We need a way to access the percentage value from outside this enum. That's why we have public getter.
    public double getPercentage() {
        return percentage;
    }

    // Previously, before we implemented this enum, when discount inside the Invoice was represented by double,
    // the logic of this method resided inside the Invoice class but now we moved it into this enum:
    private void setDiscount(double percentage) throws DiscountIsInvalid {
        final double minDiscount = 0.0;
        final double maxDiscount = 1.0;

        if(percentage < minDiscount || percentage > maxDiscount ){
            throw new DiscountIsInvalid(String.valueOf(percentage));
        }

        this.percentage = percentage;
    }


}
