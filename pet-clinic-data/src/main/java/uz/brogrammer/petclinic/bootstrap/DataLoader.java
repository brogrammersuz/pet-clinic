package uz.brogrammer.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.brogrammer.petclinic.model.Owner;
import uz.brogrammer.petclinic.model.Pet;
import uz.brogrammer.petclinic.model.PetType;
import uz.brogrammer.petclinic.model.Vet;
import uz.brogrammer.petclinic.service.OwnerService;
import uz.brogrammer.petclinic.service.PetService;
import uz.brogrammer.petclinic.service.PetTypeService;
import uz.brogrammer.petclinic.service.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogSaved = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType catSaved = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("Michael");
        owner.setLastName("Weston");
        owner.setAddress("123 Brickerel");
        owner.setCity("Miami");
        owner.setTelephone("1234567");
        ownerService.save(owner);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(dogSaved);
        mikesPet.setOwner(owner);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        owner.getPets().add(mikesPet);
        ownerService.save(owner);
        petService.save(mikesPet);

        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");
        owner1.setAddress("123 Fergana");
        owner1.setCity("Fergana");
        owner1.setTelephone("1236547");

        ownerService.save(owner1);

        Pet fionasCat = new Pet();
        fionasCat.setPetType(catSaved);
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner1);
        fionasCat.setBirthDate(LocalDate.now());

        owner1.getPets().add(fionasCat);
        ownerService.save(owner1);
        petService.save(fionasCat);

        System.out.println("Loaded Owners......");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Sam");
        vet.setLastName("Axe");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Jessie");
        vet1.setLastName("Porter");

        vetService.save(vet1);

        System.out.println("Loaded Vets ......");
    }
}
