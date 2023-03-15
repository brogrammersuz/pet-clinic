package uz.brogrammer.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import uz.brogrammer.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
