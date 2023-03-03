package uz.brogrammer.petclinic.service;

import uz.brogrammer.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
