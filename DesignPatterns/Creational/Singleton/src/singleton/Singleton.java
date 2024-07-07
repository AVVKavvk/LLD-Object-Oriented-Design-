package singleton;

public class Singleton {

    static  Singleton instance=null;

    private  Singleton(){

    };
    static  synchronized Singleton getInstance(){
        if(instance==null){
            instance= new Singleton();
        }
        return instance;
    }
    public void printInstance(){
        System.out.println("Sinlgeton Instacne : "+ instance);
    }
}
