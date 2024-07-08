package listener;

import java.io.File;

public class EmailEventListener implements  EventListener{
    private String email;
    public EmailEventListener(String email){
        this.email=email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email "+email+" "+eventType+' '+file.getName());
    }
}
