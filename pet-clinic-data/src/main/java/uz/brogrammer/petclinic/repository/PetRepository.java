package uz.brogrammer.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammer.petclinic.model.Pet;
@Repository
public interface PetRepository extends CrudRepository<Pet,Long> {
}
