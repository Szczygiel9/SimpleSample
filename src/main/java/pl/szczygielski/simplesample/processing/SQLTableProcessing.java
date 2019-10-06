package pl.szczygielski.simplesample.processing;

import pl.szczygielski.simplesample.domain.Column;
import pl.szczygielski.simplesample.domain.Table;
import pl.szczygielski.simplesample.populator.MockValuesPopulatorFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SQLTableProcessing implements TableProcessing {

    private final String INSERT_INTO = "INSERT INTO ";
    private final String VALUES = " VALUES ";

    @Override
    public String process(Table table) {
        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(INSERT_INTO)
                .append(table.getTableName());

        table.getColumns().forEach(column -> queryBuilder.append(column.getName()).append(","));

        queryBuilder.append(VALUES);
        final List<String> valuesRow = getValuesRow(table.getColumns());

        valuesRow.forEach(value -> queryBuilder.append(value).append(","));
        return queryBuilder.toString();
    }

    private List<String> getValuesRow(List<Column> columns) {
        return columns.stream()
                .map(column -> MockValuesPopulatorFactory.create(column.getType()))
                .collect(Collectors.toList());
    }
}
