package pl.szczygielski.simplesample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.szczygielski.simplesample.processing.TableProducer;

@RestController
public class TableController {

    private TableProducer producer;
    private final Logger LOGGER = LoggerFactory.getLogger(TableController.class);

    @Autowired
    public TableController(TableProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/processTable")
    public ResponseEntity<String> processTable(@RequestBody TableProcessesRequestBody requestBody) {
        LOGGER.info("Processing request body:  " + requestBody);
        final String response = producer.process(requestBody.getTable(), requestBody.getRowsToProduce());
        LOGGER.info("Response table:  " + response);
        return ResponseEntity.ok(response);
    }
}
