package uz.brogrammer.petclinic.formatter;

import lombok.RequiredArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import uz.brogrammer.petclinic.model.PetType;
import uz.brogrammer.petclinic.service.PetTypeService;

import java.text.ParseException;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class PetTypeFormatter implements Formatter<PetType> {
    private final PetTypeService petTypeService;

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        return petTypeService.findAll().stream()
                .filter(petType -> petType.getName().equals(text))
                .findAny()
                .orElseThrow(() -> new ParseException("type not found: " + text, 0));
    }

    @Override
    public String print(PetType object, Locale locale) {
        return object.getName();
    }
}
