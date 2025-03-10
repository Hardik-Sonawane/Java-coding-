package assign_4;

public class Image {
    // Protected multipliers allow subclasses to access these values.
    protected int basePriceMultiplier = 5;
    protected int baseQualityMultiplier = 1;

    // Method to display image price calculation.
    public void type(int price) {
        System.out.println("The New image price is: " + (price * basePriceMultiplier));
    }

    // Method to display image quality.
    public void quality(int star) {
        System.out.println("The image quality is: " + (star * baseQualityMultiplier));
    }
}
