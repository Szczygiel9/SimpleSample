package pl.szczygielski.simplesample.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.szczygielski.simplesample.sampledata.domain.Name;
import pl.szczygielski.simplesample.sampledata.repository.NamesRepository;

@RestController
public class NamesController {

    private NamesRepository namesRepository;

    public NamesController(NamesRepository namesRepository) {
        this.namesRepository = namesRepository;
    }

    @GetMapping(value = "/name", params = {"page", "size"})
    public Page<String> getNames(@RequestParam("page") int page, @RequestParam("size") int size) {
        final Page<Name> namePage = namesRepository.findAll(PageRequest.of(page, size));
        if (page > namePage.getTotalPages()) {
            throw new ResourceNotFoundException();
        }

        return namePage.map(Name::getValue);
    }
}
