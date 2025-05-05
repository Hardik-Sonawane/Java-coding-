
// first one class image 
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

// 2nd class photo
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

// application class 

import assign_4.*;
import assign_4_2.*;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an object of Photo (which extends Image)
        Photo photo = new Photo();

        // Use the Image functionality via Photo's inherited methods.
        System.out.print("Enter price for image: ");
        int price = Integer.parseInt(sc.nextLine());
        photo.imageType(price);

        System.out.print("Enter quality rating for image (1-10): ");
        int star = Integer.parseInt(sc.nextLine());
        photo.imageQuality(star);

        // Use the Photo-specific (overridden) methods.
        System.out.print("Enter price for photo: ");
        int photoPrice = Integer.parseInt(sc.nextLine());
        photo.type(photoPrice);

        System.out.print("Enter quality rating for photo (1-10): ");
        int photoStar = Integer.parseInt(sc.nextLine());
        photo.quality(photoStar);

        sc.close();
    }
}
