package uz.brogrammer.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "owner")
public class Owner extends Person {
    @Column(name = "address")
    private String address;
    private String city;
    private String telephone;
    @OneToMany
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if (pets != null) {
            this.pets = pets;
        }
    }

    public Pet getPet(String name, boolean ignoreNew) {
        /*
        name = name.toLowerCase();
        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                if (pet.getName().toLowerCase().equals(name)) {
                    return pet;
                }
            }
        }
        return null;
         */

        String finalName = name.toLowerCase();
        return pets.stream()
                .filter(pet -> (!ignoreNew || !pet.isNew()))
                .filter(pet -> pet.getName().toLowerCase().equals(finalName))
                .findAny()
                .orElse(null);

    }

}
