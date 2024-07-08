import java.io.File;

public class Editor {
    public EventManager events;
    private File file;
    public static final String OPEN = "open";
    public static final String SAVE = "save";

    public Editor(){
        this.events= new EventManager(OPEN,SAVE);
    }
    public void openFile(String filePath){
        file= new File(filePath);
        events.notify(OPEN,file);
    }
    public void saveFile() throws Exception{
        if(this.file!=null){
            events.notify(SAVE,file);
        }
        else throw new Exception("create file first");
    }
}

