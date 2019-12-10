package pl.szczygielski.simplesample.processing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.domain.Column;
import pl.szczygielski.simplesample.domain.Table;
import pl.szczygielski.simplesample.request.TableProcessesRequestBody;
import pl.szczygielski.simplesample.valuesprovider.ValuesProvider;

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

    private ValuesProvider valuesProvider;

    @Autowired
    public SQLTableProducer(ValuesProvider valuesProvider) {
        this.valuesProvider = valuesProvider;
    }

    @Override
    public String process(TableProcessesRequestBody requestBody) {
        final Table table = requestBody.getTable();
        final int rowsToProduce = requestBody.getRowsToProduce();

        final List<String> columnsNames = table.getColumnsNames();
        final List<Column> columns = table.getColumns();

        final StringBuilder queryBuilder = new StringBuilder();

        prepareQueryEntry(table.getTableName(), columnsNames, queryBuilder);
        IntStream.range(1, rowsToProduce - 1)
                .forEach(value -> appendValuesRow(columns, queryBuilder, true));
        appendValuesRow(columns, queryBuilder, false);

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

    private void appendValuesRow(List<Column> columns, StringBuilder queryBuilder, boolean withCommaSeparator) {
        final String valuesRow = getValuesRow(columns);
        queryBuilder
                .append(OPENING_BRACKET)
                .append(valuesRow)
                .append(CLOSING_BRACKET);

        if (withCommaSeparator) {
            queryBuilder.append(COMMA_SEPARATOR);
        }

        queryBuilder.append(NEW_LINE);
    }

    private String getValuesRow(List<Column> columns) {
        final List<String> producedValues = columns
                .stream()
                .map(column -> valuesProvider.getValue(column.getType(), column.getPredictedValue()))
                .collect(Collectors.toList());
        return String.join(COMMA_SEPARATOR, producedValues);
    }
}
