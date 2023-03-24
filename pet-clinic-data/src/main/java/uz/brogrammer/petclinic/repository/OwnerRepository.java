package uz.brogrammer.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammer.petclinic.model.Owner;

import java.util.List;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {
      Owner findByLastName(String lastName);

      List<Owner> findAllByLastNameLike(String lastName);
}
