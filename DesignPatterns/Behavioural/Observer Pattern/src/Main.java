import listener.EmailEventListener;
import listener.LogOpenEventListener;

public class Main {
    public static void main(String[] args) {

          final String OPEN = "open";
          final String SAVE = "save";

          Editor editor=new Editor();

          editor.events.subscribe(OPEN,new LogOpenEventListener("/path/vipin/vipin.txt"));
          editor.events.subscribe(SAVE,new EmailEventListener("vipin@gmail.com"));

          try {
//                editor.openFile("test.txt");
                editor.saveFile();
          }
          catch (Exception e){
              e.printStackTrace();
          }
    }
}