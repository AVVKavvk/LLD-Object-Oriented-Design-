package office;

public class RealInternetAccess implements OfficeInternetAccess{

    private String employeeName;

    public RealInternetAccess(String  name){
        this.employeeName=name;
    }

    @Override
    public void grantInternetAccess() {
        System.out.println("Granted Internet Access to : "+employeeName);
    }
}
