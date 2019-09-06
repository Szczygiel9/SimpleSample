package pl.szczygielski.simplesample.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szczygielski.simplesample.repository.SupportedTypesRepository;

import java.util.List;

@RestController
public class SupportedTypesController {

    private SupportedTypesRepository typesRepository;

    public SupportedTypesController(SupportedTypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }

    @GetMapping("/supportedTypes")
    public List<String> getSupportedTypes() {
        return typesRepository.findAll();
    }
}
