package pl.szczygielski.simplesample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.szczygielski.simplesample.processing.TableProcessing;

@RestController
public class TableController {

    private TableProcessing processing;
    private final Logger LOGGER = LoggerFactory.getLogger(TableController.class);

    @Autowired
    public TableController(TableProcessing processing) {
        this.processing = processing;
    }

    @PostMapping("/processTable")
    public ResponseEntity<String> processTable(@RequestBody TableProcessesRequestBody requestBody) {
        LOGGER.info("Processing request body:  " + requestBody);
        final String response = processing.process(requestBody.getTable(), requestBody.getRowsToProduce());
        LOGGER.info("Response table:  " + response);
        return ResponseEntity.ok(response);
    }
}
