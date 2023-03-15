package uz.brogrammer.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import uz.brogrammer.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
