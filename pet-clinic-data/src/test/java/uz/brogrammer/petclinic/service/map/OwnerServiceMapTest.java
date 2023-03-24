package uz.brogrammer.petclinic.service.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uz.brogrammer.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    private final String LAST_NAME = "Smith";
    private final Long ID = 1L;

    private final Owner owner = Owner.builder().id(ID).lastName(LAST_NAME).build();

    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById(){
        ownerServiceMap.deleteById(ID);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete(){
        var objectToDelete = ownerServiceMap.findById(ID);
        ownerServiceMap.delete(objectToDelete);
        assertEquals(null, ownerServiceMap.findById(ID));
    }

    @Test
    void findByLastNameNotFound(){
        Owner owner = ownerServiceMap.findByLastName("something");
        assertNull(owner);
    }

    @Test
    void saveExistingId(){
        Long id = 2L;
        Owner savedOwner = ownerServiceMap.save(Owner.builder().id(id).build());
        assertEquals(id, savedOwner.getId());
        assertNull(savedOwner.getLastName());
        assertEquals(2, ownerServiceMap.findAll().size());
    }

    @Test
    void saveNoId(){
        Owner owner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(owner);
        assertNotNull(owner.getId());
    }

    @Test
    void findById(){
        Owner owner = ownerServiceMap.findById(ID);
        assertEquals(ID, owner.getId());
    }

    @Test
    void findByLastName(){
        Owner smith = ownerServiceMap.findByLastName(LAST_NAME);
        assertNotNull(smith);
    }

}