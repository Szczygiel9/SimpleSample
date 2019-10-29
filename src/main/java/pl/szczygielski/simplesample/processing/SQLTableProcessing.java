package pl.szczygielski.simplesample.processing;

import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.domain.Column;
import pl.szczygielski.simplesample.domain.ColumnType;
import pl.szczygielski.simplesample.domain.Table;
import pl.szczygielski.simplesample.populator.MockValuesPopulator;
import pl.szczygielski.simplesample.populator.ValuesPopulator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SQLTableProcessing implements TableProcessing {

    private ValuesPopulator populator;

    private static final String INSERT_INTO = "INSERT INTO";
    private static final String VALUES = "VALUES";
    private static final String OPENING_BRACKET = " ( ";
    private static final String CLOSING_BRACKET = " ) ";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public SQLTableProcessing(ValuesPopulator populator) {
        this.populator = populator;
    }

    @Override
    public String process(Table table, int rowsToProduce) {
        final List<String> columnsNames = table.getColumns().stream().map(Column::getName).collect(Collectors.toList());
        final String columnsWithSeparator = String.join(", ", columnsNames);

        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder
                .append(INSERT_INTO)
                .append(SPACE)
                .append(table.getTableName())
                .append(SPACE)
                .append(OPENING_BRACKET)
                .append(columnsWithSeparator)
                .append(CLOSING_BRACKET)
                .append(NEW_LINE)
                .append(VALUES)
                .append(NEW_LINE);

        final List<ColumnType> columnTypes = table.getColumns().stream().map(Column::getType).collect(Collectors.toList());

        IntStream.range(1, rowsToProduce)
                .forEach(value -> {
                    final String valuesRow = getValuesRow(columnTypes);
                    queryBuilder
                            .append(OPENING_BRACKET)
                            .append(valuesRow)
                            .append(CLOSING_BRACKET)
                            .append(",")
                            .append(NEW_LINE);
                });

        return queryBuilder.append(";").toString();
    }

    private String getValuesRow(List<ColumnType> columnTypes) {
        final List<String> producedValues = columnTypes
                .stream()
                .map(populator::create)
                .collect(Collectors.toList());
        return String.join(", ", producedValues);
    }
}
