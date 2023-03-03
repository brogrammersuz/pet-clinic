package uz.brogrammer.petclinic.service;

import uz.brogrammer.petclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long> {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
