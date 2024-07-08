package logger;

public class DebugLogger extends Logger{

    public DebugLogger(int level){
        this.level=level;
    }
    @Override
    public void displayInfo(String msg) {
        System.out.println("DEBUG "+ msg );
    }
}
