package listener;

import java.io.File;

public class LogOpenEventListener implements  EventListener{

    private File log;
    public LogOpenEventListener(String file){
        this.log=new File(file);
    }
    @Override
    public void update(String eventType, File file) {
        System.out.println("Open " + log+ "  "+ eventType+"  "+ file.getName());
    }
}
