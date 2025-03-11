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


// photo class code

package assign_4_2;

import assign_4.Image;

public class Photo extends Image {

    private int photoPriceMultiplier = 10;
    private int photoQualityMultiplier = 5;


    @Override
    public void type(int price) {
        System.out.println("The New photo price is: " + (price * photoPriceMultiplier));
    }


    @Override
    public void quality(int star) {
        System.out.println("The photo quality out of 50 is: " + (star * photoQualityMultiplier));
    }


    public void imageType(int price) {
        super.type(price);
    }

    public void imageQuality(int star) {
        super.quality(star);
    }
}

// application class code
