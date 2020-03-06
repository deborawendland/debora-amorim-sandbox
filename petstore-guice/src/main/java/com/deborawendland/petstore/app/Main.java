package com.deborawendland.petstore.app;

import com.deborawendland.petstore.module.PetStoreModule;
import com.deborawendland.petstore.petStoreService.Bath;
import com.deborawendland.petstore.service.PetStore;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new PetStoreModule());
        PetStore petStore = injector.getInstance(PetStore.class);
        UUID plutoID = petStore.addPet("Pluto", "Cat", 4);

        System.out.println(petStore.doBath(plutoID, Bath.BathType.DRY, Bath.Perfume.WITH));
    }

}
