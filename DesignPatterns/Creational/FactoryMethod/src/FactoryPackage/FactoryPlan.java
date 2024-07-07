package FactoryPackage;

public class FactoryPlan {

    Plan createPlan(String planName){

        if(planName.equalsIgnoreCase("Domestic"))  return new DomesticPlan();
        else if(planName.equalsIgnoreCase("Commercial")) return  new CommercialPlan();
        else if(planName.equalsIgnoreCase("Industory")) return  new IndustoryPlan();
        else return  null;
    }
}
