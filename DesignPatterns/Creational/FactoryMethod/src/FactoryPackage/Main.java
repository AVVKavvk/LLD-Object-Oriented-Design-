package FactoryPackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("vipin");

        FactoryPlan factory=new FactoryPlan();

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter plan name : ");
        String planName= sc.nextLine();
        System.out.println("Enter units : ");
        int units = sc.nextInt();

        Plan obj=factory.createPlan(planName);

        System.out.println(planName +" Rate is : "+obj.getRate());
        System.out.println("Total bill is : " );
        obj.calculateRate(units);

    }
}
