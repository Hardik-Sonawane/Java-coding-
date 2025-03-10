import assign_4.*;        
import assign_4_2.*;      
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        Image image = new Image();
        Photo photo = new Photo(); 

        System.out.print("Enter price for image: ");
        int price = Integer.parseInt(sc.nextLine());  

      
        image.type(price);

     
        System.out.print("Enter quality rating for image (1-10): ");
        int star = Integer.parseInt(sc.nextLine());  
        image.quality(star);

        
        System.out.print("Enter price for photo: ");
        int photoPrice = Integer.parseInt(sc.nextLine());  

      
        photo.type(photoPrice);

        
        System.out.print("Enter quality rating for photo (1-10): ");
        int photoStar = Integer.parseInt(sc.nextLine());  
        photo.quality(photoStar);

        sc.close(); 
    }
}

