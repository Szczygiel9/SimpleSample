package pl.szczygielski.simplesample.processing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.szczygielski.simplesample.domain.ColumnType;
import pl.szczygielski.simplesample.domain.Table;
import pl.szczygielski.simplesample.populator.MockValuesPopulator;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MockTableProcessingTest {

    private TableProcessing tableProcessing;
    private final String MOCK_VALUES_HEADER = "Mock values for sample-table table:\n";

    @BeforeEach
    void setUp() {
        tableProcessing = new MockTableProcessing(new MockValuesPopulator());
    }

    @Test
    void processingStringsTableWithSingleRow() {
        Table table = createSingleTypeTable(ColumnType.VARCHAR);
        String processResult = tableProcessing.process(table);

        String expectedResult = MOCK_VALUES_HEADER + "MockVal MockVal MockVal MockVal ";
        assertEquals(expectedResult, processResult);
    }

    @Test
    void processingBoolTableWithSingleRow() {
        Table table = createSingleTypeTable(ColumnType.BOOL);
        String processResult = tableProcessing.process(table);

        String expectedResult = MOCK_VALUES_HEADER + "true true true true ";
        assertEquals(expectedResult, processResult);
    }

    @Test
    void processingIntegerTableWithSingleRow() {
        Table table = createSingleTypeTable(ColumnType.INTEGER);
        String processResult = tableProcessing.process(table);

        String expectedResult = MOCK_VALUES_HEADER + "16 16 16 16 ";
        assertEquals(expectedResult, processResult);
    }

    @Test
    void processingDateTableWithSingleRow() {
        Table table = createSingleTypeTable(ColumnType.DATE);
        String processResult = tableProcessing.process(table);

        String expectedDate = new SimpleDateFormat("DD-MM-yyyy").format(Date.from(Instant.now()));
        String expectedResult = MOCK_VALUES_HEADER + expectedDate + " "
                + expectedDate + " "
                + expectedDate + " "
                + expectedDate + " ";
        assertEquals(expectedResult, processResult);
    }

    @Test
    void processingFloatTableWithSingleRow() {
        Table table = createSingleTypeTable(ColumnType.FLOAT);
        String processResult = tableProcessing.process(table);

        String expectedResult = MOCK_VALUES_HEADER + "12.2 12.2 12.2 12.2 ";
        assertEquals(expectedResult, processResult);
    }

    private Table createSingleTypeTable(ColumnType type) {
        return new Table("sample-table")
                .withColumn("sample-column1", type)
                .withColumn("sample-column2", type)
                .withColumn("sample-column3", type)
                .withColumn("sample-column4", type);
    }
}
