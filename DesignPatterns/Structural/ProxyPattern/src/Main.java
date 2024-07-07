import office.OfficeInternetAccess;
import office.ProxyInternetAccess;

public class Main {
    public static void main(String[] args) {

        OfficeInternetAccess officeAccess= new ProxyInternetAccess("vipin Kumawat");
        officeAccess.grantInternetAccess();

    }
}