package com.deborawendland.petstore.service;

import com.deborawendland.petstore.exceptions.IllegalPetIDArgumentException;
import com.deborawendland.petstore.model.Pet;
import com.deborawendland.petstore.petStoreService.Bath;
import com.deborawendland.petstore.petStoreService.HairCut;
import com.deborawendland.petstore.petStoreService.PetStoreService;

import java.util.*;
import java.util.stream.Collectors;

public class PetStore {

    private Map<UUID, Pet> registeredPets;
    private Map<UUID, List<PetStoreService>> serviceLogs;

    public PetStore() {
        this.registeredPets = new HashMap<>();
        this.serviceLogs = new HashMap<>();
    }

    public UUID addPet(String name, String race, int age){
        Pet pet = new Pet(name, race, age);
        UUID id = UUID.randomUUID();
        registeredPets.put(id, pet);
        serviceLogs.put(id, new ArrayList<>());
        return id;
    }

    public void removePet(UUID id){
        registeredPets.remove(id);
    }

    public Map<UUID, Pet> searchByAge(int age){
        Map<UUID, Pet> matchedPets = new HashMap<>();
        for (Map.Entry<UUID, Pet> entry : registeredPets.entrySet()){
            if (entry.getValue().getAge() == age){
                matchedPets.put(entry.getKey(), entry.getValue());
            }
        }
        return matchedPets;
    }

    public String doBath (UUID petID, Bath.BathType bathType, Bath.Perfume perfume){
        if (serviceLogs.containsKey(petID)){
            Bath bath = new Bath(perfume, bathType);
            bath.doService();
            serviceLogs.get(petID).add(bath);
            return bath.getServiceDescription();
        } else {
            throw new IllegalPetIDArgumentException("Invalid Pet ID: " + petID.toString());
        }
    }

    public String doHairCut (UUID petID, HairCut.HairCutLength hairCutLength){
        if (serviceLogs.containsKey(petID)){
            HairCut hairCut = new HairCut(hairCutLength);
            hairCut.doService();
            serviceLogs.get(petID).add(hairCut);
            return hairCut.getServiceDescription();
        } else {
            throw new IllegalPetIDArgumentException("Invalid Pet ID: " + petID.toString());
        }
    }

    public Map<UUID, Double> getTop10PetsRevenue() {
        Map<UUID, Double> petsRevenue = new HashMap<>();
        for (Map.Entry<UUID, List<PetStoreService>> entry : serviceLogs.entrySet()){
            if (calculatePetRevenue(entry.getKey()) > 0){
                petsRevenue.put(entry.getKey(), calculatePetRevenue(entry.getKey()));
            }
        }
        return petsRevenue.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private double calculatePetRevenue(UUID petID){
        double cost = 0;
        for (PetStoreService entry : serviceLogs.get(petID)){
            cost = cost + entry.getCost();
        }
        return cost;
    }

    public Map<UUID, Pet> getRegisteredPets() {
        return registeredPets;
    }

    public Map<UUID, List<PetStoreService>> getServiceLogs() {
        return serviceLogs;
    }
}
