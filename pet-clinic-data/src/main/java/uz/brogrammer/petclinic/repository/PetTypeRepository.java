package uz.brogrammer.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import uz.brogrammer.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
