// image class code 
package assign_4;

public class Image {

    protected int basePriceMultiplier = 5;
    protected int baseQualityMultiplier = 1;


    public void type(int price) {
        System.out.println("The New image price is: " + (price * basePriceMultiplier));
    }


    public void quality(int star) {
        System.out.println("The image quality is: " + (star * baseQualityMultiplier));
    }
}



