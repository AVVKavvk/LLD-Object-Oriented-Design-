package FactoryPackage;

public class DomesticPlan  extends Plan {

    // rate=3;  ----->>>>>   error
    @Override
    double getRate() {
        this.rate=3;
        return this.rate;
    }
}
