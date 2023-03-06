package uz.brogrammer.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.brogrammer.petclinic.service.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {
        var list = ownerService.findAll().stream()
                .sorted((a, b) -> (a.getId() < b.getId()) ? 1 : 0);
        model.addAttribute("owners", list);
        return "owner/index";
    }
}
