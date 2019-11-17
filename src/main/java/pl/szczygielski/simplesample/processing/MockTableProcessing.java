package pl.szczygielski.simplesample.processing;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.domain.Table;
import pl.szczygielski.simplesample.populator.ValuesFactory;

@Component
@Profile("mock")
public class MockTableProcessing implements TableProducer {

    private ValuesFactory valuesFactory;

    public MockTableProcessing(ValuesFactory valuesFactory) {
        this.valuesFactory = valuesFactory;
    }

    @Override
    public String process(Table table, int rowsToProduce) {
        StringBuilder mockResultBuilder = new StringBuilder()
                .append("Mock values for ")
                .append(table.getTableName())
                .append(" table:")
                .append("\n");

        table.getColumns()
                .forEach(column -> {
                    mockResultBuilder.append(valuesFactory.create(column.getType()));
                    mockResultBuilder.append(" ");
                });
        return mockResultBuilder.toString();
    }
}
