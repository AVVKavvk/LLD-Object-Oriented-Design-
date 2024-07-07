package singleton;

public class Main {
    public static void main(String[] args) {

     Singleton obj1= Singleton.getInstance();
     obj1.printInstance();

     Singleton ob2=Singleton.getInstance();

     ob2.printInstance();

    }
}