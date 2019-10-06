package pl.szczygielski.simplesample.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szczygielski.simplesample.domain.ColumnType;

import java.util.List;

@RestController
public class SupportedTypesController {

    @GetMapping("/supportedTypes")
    public ColumnType[] getSupportedTypes() {
        return ColumnType.values();
    }
}
