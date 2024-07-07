package shopkeaper;

import com.company.Phones.IPhone;
import com.company.Phones.Redmi;
import com.company.Phones.Samsung;

public class Shopkeaper {

    IPhone iphone;
    Samsung samsung;
    Redmi redmi;
    public Shopkeaper(){
        iphone= new IPhone();
        samsung= new Samsung();
        redmi = new Redmi();
    }
    public void getIPhoneDetails(){
        iphone.getModel();
        iphone.getRupee();
    }
    public void getSamsungDetails(){
        samsung.getModel();
        samsung.getRupee();
    }
    public void getRedmiDetails(){
        redmi.getModel();
        redmi.getRupee();
    }
}
