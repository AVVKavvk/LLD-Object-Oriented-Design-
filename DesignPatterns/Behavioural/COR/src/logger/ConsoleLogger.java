package logger;

public class ConsoleLogger extends Logger{

    public ConsoleLogger(int level){
        this.level=level;
    }
    @Override
    public void displayInfo(String msg) {
        System.out.println("CONSOLE "+ msg );
    }
}
