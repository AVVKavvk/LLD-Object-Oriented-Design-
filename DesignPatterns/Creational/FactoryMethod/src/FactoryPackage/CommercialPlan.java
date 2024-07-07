package FactoryPackage;

public class CommercialPlan extends  Plan{

    @Override
    double getRate() {
        this.rate=5.0;
        return this.rate;
    }
}
