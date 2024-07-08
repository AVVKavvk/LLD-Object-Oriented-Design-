package logger;

public class ErrorLogger extends  Logger{

    public ErrorLogger(int level){
        this.level=level;
    }
    @Override
    public void displayInfo(String msg) {
        System.out.println("ERROR "+ msg );
    }
}
