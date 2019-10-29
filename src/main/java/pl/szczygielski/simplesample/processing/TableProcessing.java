package pl.szczygielski.simplesample.processing;

import pl.szczygielski.simplesample.domain.Table;

public interface TableProcessing {

    String process(Table table, int rowsToProduce);
}
