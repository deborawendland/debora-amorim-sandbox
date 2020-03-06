package com.deborawendland.petstore.petStoreService;

public class HairCut implements PetStoreService {

    public enum HairCutLength {SHORT, LONG}

    private static final int PLAINHAIRCUTPRICE = 15;

    private HairCutLength hairCutLength;
    private double cost;
    private String serviceDescription;

    public HairCut(HairCutLength hairCutLength) {
        this.hairCutLength = hairCutLength;
    }

    @Override
    public void doService() {
        serviceDescription = "HAIRCUT: ";
        cost = PLAINHAIRCUTPRICE;
        switch (hairCutLength){
            case LONG:
                serviceDescription = serviceDescription.concat("\nLong");
                cost = cost + 5;
                break;
            case SHORT:
                serviceDescription = serviceDescription.concat("\nShort");
                break;
        }
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getServiceDescription() {
        return serviceDescription;
    }

    public HairCutLength getHairCutLength() {
        return hairCutLength;
    }

}
