package com.deborawendland.petstore.module;

import com.deborawendland.petstore.service.PetStore;
import com.google.inject.AbstractModule;

public class PetStoreModule extends AbstractModule {

    @Override
    protected void configure(){
        bind(PetStore.class);
    }

}
