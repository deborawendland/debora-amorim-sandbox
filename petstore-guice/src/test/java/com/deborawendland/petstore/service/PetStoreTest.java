package com.deborawendland.petstore.service;

import com.deborawendland.petstore.exceptions.IllegalPetIDArgumentException;
import com.deborawendland.petstore.model.Pet;
import com.deborawendland.petstore.module.PetStoreModule;
import com.deborawendland.petstore.petStoreService.Bath;
import com.deborawendland.petstore.petStoreService.HairCut;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;
import java.util.UUID;

public class PetStoreTest {

    private Injector injector;
    private PetStore petStore;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init(){
        this.injector = Guice.createInjector(new PetStoreModule());
        this.petStore = injector.getInstance(PetStore.class);
    }

    @Test
    public void addPetTest() {
        petStore.getRegisteredPets().clear();
        UUID lailaID = petStore.addPet("Laila", "Dog", 5);
        Assert.assertTrue(petStore.getRegisteredPets().containsKey(lailaID));
        Assert.assertTrue(petStore.getRegisteredPets().size() == 1);
    }

    @Test
    public void removePetTest() {
        UUID plutoID = petStore.addPet("Pluto", "Dog", 2);
        Assert.assertTrue(petStore.getRegisteredPets().containsKey(plutoID));
        petStore.removePet(plutoID);
        Assert.assertFalse(petStore.getRegisteredPets().containsKey(plutoID));
    }

    @Test
    public void searchByAgeTest() {
        petStore.getRegisteredPets().clear();
        UUID lailaID = petStore.addPet("Laila", "Dog", 5);
        UUID plutoID = petStore.addPet("Pluto", "Dog", 2);
        UUID rexID = petStore.addPet("Rex", "Dog", 7);
        UUID bolachaID = petStore.addPet("Bolacha", "Cat", 7);

        for (Map.Entry<UUID, Pet> entry : petStore.searchByAge(7).entrySet()){
            Assert.assertTrue(entry.getValue().getAge() == 7);
        }

        Assert.assertTrue(petStore.searchByAge(7).entrySet().size() == 2);
    }

    @Test
    public void doBathDryWithoutPerfumeTest() {
        petStore.getServiceLogs().clear();
        petStore.getRegisteredPets().clear();
        UUID bolachaID = petStore.addPet("Bolacha", "Cat", 7);
        Assert.assertTrue(petStore.doBath(bolachaID, Bath.BathType.DRY, Bath.Perfume.WITH).equalsIgnoreCase("bath: dry\nwith perfume"));
        Assert.assertTrue(petStore.getServiceLogs().containsKey(bolachaID));
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).size() == 1);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0) instanceof Bath);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0).getCost() == 25);
    }

    @Test
    public void doBathDryWithPerfumeTest() {
        petStore.getServiceLogs().clear();
        petStore.getRegisteredPets().clear();
        UUID bolachaID = petStore.addPet("Bolacha", "Cat", 7);
        Assert.assertTrue(petStore.doBath(bolachaID, Bath.BathType.DRY, Bath.Perfume.WITH).equalsIgnoreCase("bath: dry\nwith perfume"));
        Assert.assertTrue(petStore.getServiceLogs().containsKey(bolachaID));
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).size() == 1);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0) instanceof Bath);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0).getCost() == 25);
    }

    @Test
    public void doBathWetWithPerfumeTest() {
        petStore.getServiceLogs().clear();
        petStore.getRegisteredPets().clear();
        UUID bolachaID = petStore.addPet("Bolacha", "Cat", 7);
        Assert.assertTrue(petStore.doBath(bolachaID, Bath.BathType.WET, Bath.Perfume.WITH).equalsIgnoreCase("bath: wet\nwith perfume"));
        Assert.assertTrue(petStore.getServiceLogs().containsKey(bolachaID));
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).size() == 1);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0) instanceof Bath);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0).getCost() == 15);
    }

    @Test
    public void doBathInvalidPetIDTest() {
        UUID lailaID = petStore.addPet("Laila", "Dog", 5);
        petStore.getServiceLogs().clear();
        petStore.getRegisteredPets().clear();

        thrown.expect(IllegalPetIDArgumentException.class);
        thrown.expectMessage("Invalid Pet ID: " + lailaID.toString());
        petStore.doBath(lailaID, Bath.BathType.DRY, Bath.Perfume.WITH);
    }

    @Test
    public void doBathWetWithoutPerfumeTest() {
        petStore.getServiceLogs().clear();
        petStore.getRegisteredPets().clear();
        UUID bolachaID = petStore.addPet("Bolacha", "Cat", 7);
        Assert.assertTrue(petStore.doBath(bolachaID, Bath.BathType.WET, Bath.Perfume.WITHOUT).equalsIgnoreCase("bath: wet\nwithout perfume"));
        Assert.assertTrue(petStore.getServiceLogs().containsKey(bolachaID));
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).size() == 1);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0) instanceof Bath);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0).getCost() == 10);
    }

    @Test
    public void doHairCutShortTest() {
        petStore.getServiceLogs().clear();
        petStore.getRegisteredPets().clear();
        UUID bolachaID = petStore.addPet("Bolacha", "Cat", 7);
        Assert.assertTrue(petStore.doHairCut(bolachaID, HairCut.HairCutLength.SHORT).equalsIgnoreCase("haircut: \nshort"));
        Assert.assertTrue(petStore.getServiceLogs().containsKey(bolachaID));
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).size() == 1);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0) instanceof HairCut);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0).getCost() == 15);
    }

    @Test
    public void doHairCutLongTest() {
        petStore.getServiceLogs().clear();
        petStore.getRegisteredPets().clear();
        UUID bolachaID = petStore.addPet("Bolacha", "Cat", 7);
        Assert.assertTrue(petStore.doHairCut(bolachaID, HairCut.HairCutLength.LONG).equalsIgnoreCase("haircut: \nlong"));
        Assert.assertTrue(petStore.getServiceLogs().containsKey(bolachaID));
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).size() == 1);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0) instanceof HairCut);
        Assert.assertTrue(petStore.getServiceLogs().get(bolachaID).get(0).getCost() == 20);
    }

    @Test
    public void getTop10PetsRevenueSortedTest() {
        petStore.getServiceLogs().clear();
        petStore.getRegisteredPets().clear();
        UUID bolachaID = petStore.addPet("Bolacha", "Cat", 7);
        UUID lailaID = petStore.addPet("Laila", "Dog", 5);
        UUID plutoID = petStore.addPet("Pluto", "Dog", 2);
        UUID rexID = petStore.addPet("Rex", "Dog", 7);

        petStore.doHairCut(bolachaID, HairCut.HairCutLength.LONG);
        petStore.doHairCut(rexID, HairCut.HairCutLength.SHORT);
        petStore.doBath(lailaID, Bath.BathType.DRY, Bath.Perfume.WITHOUT);
        petStore.doBath(plutoID, Bath.BathType.WET, Bath.Perfume.WITHOUT);

        Map.Entry<UUID, Double> auxEntry = null;
        for (Map.Entry<UUID, Double> entry : petStore.getTop10PetsRevenue().entrySet()){
            if (auxEntry == null){
                auxEntry = entry;
            } else {
                Assert.assertTrue(auxEntry.getValue() >= entry.getValue());
            }
        }
    }

    @Test
    public void getTop10PetsRevenueUnservicedPetsTest() {
        petStore.getServiceLogs().clear();
        petStore.getRegisteredPets().clear();
        UUID bolachaID = petStore.addPet("Bolacha", "Cat", 7);
        UUID lailaID = petStore.addPet("Laila", "Dog", 5);

        Assert.assertTrue(petStore.getTop10PetsRevenue().isEmpty());
    }
}
