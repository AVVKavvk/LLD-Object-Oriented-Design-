package office;

public class ProxyInternetAccess implements  OfficeInternetAccess{

    private String employeeName;
    RealInternetAccess realAccess;
    public ProxyInternetAccess(String name){
        this.employeeName=name;
        realAccess=new RealInternetAccess(employeeName);
    }

    @Override
    public void grantInternetAccess() {

        if(getRole(employeeName)>4){
            realAccess.grantInternetAccess();
        }
        else{
            System.out.println("Your role is below 5 "+ employeeName);
        }
    }
    private int getRole(String employeeName){
        //
        //
        return 3;
//        return 5;
    }
}
