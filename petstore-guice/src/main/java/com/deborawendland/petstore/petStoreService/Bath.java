package com.deborawendland.petstore.petStoreService;

public class Bath implements PetStoreService {

    public enum Perfume {WITH, WITHOUT}
    public enum BathType {WET, DRY}

    private static final int PLAINBATHPRICE = 10;

    private Perfume perfume;
    private BathType bathType;
    private double cost;
    private String serviceDescription;

    public Bath(Perfume perfume, BathType bathType) {
        this.perfume = perfume;
        this.bathType = bathType;
    }

    @Override
    public void doService() {
        cost = PLAINBATHPRICE;
        serviceDescription = "BATH: ";
        switch (bathType){
            case DRY:
                cost = cost + 10;
                serviceDescription = serviceDescription.concat("DRY");
                break;
            case WET:
                serviceDescription = serviceDescription.concat("WET");
                break;
        }
        switch (perfume){
            case WITH:
                cost = cost + 5;
                serviceDescription = serviceDescription.concat("\nwith perfume");
                break;
            case WITHOUT:
                serviceDescription = serviceDescription.concat("\nwithout perfume");
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

    public Perfume getPerfume() {
        return perfume;
    }

    public BathType getTypeOfBath() {
        return bathType;
    }


}
