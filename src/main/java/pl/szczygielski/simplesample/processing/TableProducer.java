package pl.szczygielski.simplesample.processing;

import pl.szczygielski.simplesample.domain.Table;

public interface TableProducer {

    String process(Table table, int rowsToProduce);
}
