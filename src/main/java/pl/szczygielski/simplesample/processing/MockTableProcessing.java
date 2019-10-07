package pl.szczygielski.simplesample.processing;

import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.domain.Table;
import pl.szczygielski.simplesample.populator.ValuesPopulator;

@Component
public class MockTableProcessing implements TableProcessing {

    private ValuesPopulator valuesPopulator;

    public MockTableProcessing(ValuesPopulator valuesPopulator) {
        this.valuesPopulator = valuesPopulator;
    }

    @Override
    public String process(Table table) {
        StringBuilder mockResultBuilder = new StringBuilder()
                .append("Mock values for ")
                .append(table.getTableName())
                .append(" table:")
                .append("\n");

        table.getColumns()
                .forEach(column -> {
                    mockResultBuilder.append(valuesPopulator.create(column.getType()));
                    mockResultBuilder.append(" ");
                });
        return mockResultBuilder.toString();
    }
}
