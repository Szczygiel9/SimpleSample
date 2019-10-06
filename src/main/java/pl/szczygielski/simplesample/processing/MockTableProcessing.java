package pl.szczygielski.simplesample.processing;

import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.domain.Table;

@Component
public class MockTableProcessing implements TableProcessing {

    @Override
    public String process(Table table) {
        return "";
    }
}
