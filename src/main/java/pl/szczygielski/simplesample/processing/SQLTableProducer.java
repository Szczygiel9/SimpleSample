package pl.szczygielski.simplesample.processing;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.domain.ColumnType;
import pl.szczygielski.simplesample.domain.Table;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SQLTableProducer implements TableProducer {

    private static final String INSERT_INTO = "INSERT INTO";
    private static final String VALUES = "VALUES";
    private static final String OPENING_BRACKET = " ( ";
    private static final String CLOSING_BRACKET = " ) ";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String COMMA_SEPARATOR = ", ";

    @Override
    public String process(Table table, int rowsToProduce) {
        final List<String> columnsNames = table.getColumnsNames();
        final List<ColumnType> columnTypes = table.getColumnsTypes();

        final StringBuilder queryBuilder = new StringBuilder();

        prepareQueryEntry(table.getTableName(), columnsNames, queryBuilder);
        IntStream.range(1, rowsToProduce - 1)
                .forEach(value -> appendValuesRow(columnTypes, queryBuilder, true));
        appendValuesRow(columnTypes, queryBuilder, false);

        return queryBuilder.append(";").toString();
    }

    private StringBuilder prepareQueryEntry(String tableName, List<String> columnsNames, StringBuilder queryBuilder) {
        final String separatedColumnNames = String.join(COMMA_SEPARATOR, columnsNames);
        return queryBuilder
                .append(INSERT_INTO)
                .append(SPACE)
                .append(tableName)
                .append(SPACE)
                .append(OPENING_BRACKET)
                .append(separatedColumnNames)
                .append(CLOSING_BRACKET)
                .append(NEW_LINE)
                .append(VALUES)
                .append(NEW_LINE);
    }

    private void appendValuesRow(List<ColumnType> columnTypes, StringBuilder queryBuilder, boolean withCommaSeparator) {
        final String valuesRow = getValuesRow(columnTypes);
        queryBuilder
                .append(OPENING_BRACKET)
                .append(valuesRow)
                .append(CLOSING_BRACKET);

        if (withCommaSeparator) {
            queryBuilder.append(COMMA_SEPARATOR);
        }

        queryBuilder.append(NEW_LINE);
    }

    private String getValuesRow(List<ColumnType> columnTypes) {
        final List<String> producedValues = columnTypes
                .stream()
                .map(ColumnType::produceValue)
                .collect(Collectors.toList());
        return String.join(COMMA_SEPARATOR, producedValues);
    }
}
