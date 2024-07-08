import logger.ConsoleLogger;
import logger.DebugLogger;
import logger.ErrorLogger;
import logger.Logger;

public class Main {
    private static Logger doChaining(){
        ConsoleLogger consoleLogger=new ConsoleLogger(1);
        ErrorLogger errorLogger=new ErrorLogger(2);
        consoleLogger.setNExtLogger(errorLogger);
        DebugLogger debugLogger=new DebugLogger(3);
        errorLogger.setNExtLogger(debugLogger);
        return consoleLogger;
    }
    public static void main(String[] args) {

        Logger logger = doChaining();
        logger.logMessage(Logger.CONSOLE,"HI this is console ");
        logger.logMessage(Logger.ERROR,"HI this is error ");
        logger.logMessage(Logger.DEBUG,"HI this is debug ");
    }
}