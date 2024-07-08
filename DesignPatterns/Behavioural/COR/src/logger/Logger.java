package logger;

public abstract    class Logger {
    public static int CONSOLE=1;
    public static int ERROR=2;
    public static int DEBUG=3;

    protected int level;

    public Logger nextLogger;

    public void setNExtLogger(Logger l){
        this.nextLogger=l;
    }
   public void logMessage(int level,String msg){
       if(this.level<=level){
            this.displayInfo(msg);
       }
       if(this.nextLogger!=null){
           this.nextLogger.logMessage(level,msg);
       }
   }
   public abstract void displayInfo(String msg);

}
