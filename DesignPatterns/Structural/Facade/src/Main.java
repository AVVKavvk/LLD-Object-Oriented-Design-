import shopkeaper.Shopkeaper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Shopkeaper sk= new Shopkeaper();

        do {
            System.out.println("--------*******---------------");
            System.out.println("  1. Apple Details  ");
            System.out.println("  2. Samsung Details  ");
            System.out.println("  3. Redmi Details  ");
            System.out.println("  4. Exit   ");
            System.out.println("Enter a number : ");
            Scanner sc= new Scanner(System.in);
            int val=sc.nextInt();

            switch (val){
                case 1:{
                    sk.getIPhoneDetails();
                    break;
                }
                case 2:{
                    sk.getSamsungDetails();
                    break;
                }
                case 3:{
                    sk.getRedmiDetails();
                    break;
                }
                case 4: {
                    return ;

                }

            }
        }
        while(true);

    }
}