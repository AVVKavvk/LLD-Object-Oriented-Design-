import java.io.File;
import java.util.*;

public class EventManager {
    Map<String , List<listener.EventListener>> listeners= new HashMap<>();

    public EventManager(String ...operations){
        for(String operation :operations){
            this.listeners.put(operation,new ArrayList<>());
        }
    }
    public void subscribe(String eventType,listener.EventListener listener ){
//        List<listener.EventListener> users= listeners.get(eventType);
        listeners.get(eventType).add(listener);
//        users.add(listener);
    }

    public void unsubscribe(String eventType, listener.EventListener listener){
//        List<listener.EventListener> users= listeners.get(eventType);
        this.listeners.get(eventType).remove(listener);
//        users.remove(listener);
    }


    public void notify(String eventType, File file){
        List<listener.EventListener> users=listeners.get(eventType);
        for(listener.EventListener listener : users){
            listener.update(eventType,file);
        }
    }
}
