package uz.brogrammer.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.brogrammer.petclinic.model.Owner;
import uz.brogrammer.petclinic.model.Vet;
import uz.brogrammer.petclinic.service.OwnerService;
import uz.brogrammer.petclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Michael");
        owner.setLastName("Weston");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");

        ownerService.save(owner1);
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
