package uz.brogrammer.petclinic.service.map;

import org.springframework.stereotype.Service;
import uz.brogrammer.petclinic.model.Owner;
import uz.brogrammer.petclinic.service.OwnerService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream()
                .filter(a -> a.getValue().getLastName().equals(lastName))
                .findFirst()
                .map(a -> a.getValue())
                .orElse(null);
    }
}
