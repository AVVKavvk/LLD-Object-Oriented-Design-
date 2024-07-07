package FactoryPackage;

 public abstract class Plan {
    protected  double rate;
    abstract  double getRate();

    void calculateRate(int units){
        System.out.println("Rate is : " + this.rate);
        System.out.println("Total Bill is : "+ units*this.rate);
    }

}
