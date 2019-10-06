package pl.szczygielski.simplesample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.szczygielski.simplesample.domain.Table;
import pl.szczygielski.simplesample.processing.TableProcessing;

@RestController
public class TableController {

    private TableProcessing processing;

    @Autowired
    public TableController(TableProcessing processing) {
        this.processing = processing;
    }

    @PostMapping("/processTable")
    public ResponseEntity<String> processTable(@RequestBody Table table) {
        final String response = processing.process(table);
        return ResponseEntity.ok(response);
    }
}
