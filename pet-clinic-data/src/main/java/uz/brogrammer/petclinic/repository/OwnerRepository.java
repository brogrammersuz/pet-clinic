package uz.brogrammer.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammer.petclinic.model.Owner;
@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {
      Owner findByLastName(String lastName);
}
