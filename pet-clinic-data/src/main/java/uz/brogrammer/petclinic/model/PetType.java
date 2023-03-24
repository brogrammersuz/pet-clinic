package uz.brogrammer.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class PetType extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
