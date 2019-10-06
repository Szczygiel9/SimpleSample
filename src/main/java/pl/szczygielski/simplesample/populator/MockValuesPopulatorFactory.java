package pl.szczygielski.simplesample.populator;

import lombok.SneakyThrows;
import pl.szczygielski.simplesample.domain.ColumnType;

import javax.activation.UnsupportedDataTypeException;
import java.time.Instant;
import java.util.Date;

public class MockValuesPopulatorFactory {

    private MockValuesPopulatorFactory() {
    }

    @SneakyThrows
    public static String create(ColumnType type) {
        switch (type) {
            case BOOL:
                return "true";
            case DATE:
                return Date.from(Instant.now()).toString();
            case FLOAT:
                return "12.2";
            case INTEGER:
                return "16";
            case VARCHAR:
                return "Daniel";
            default:
                throw new UnsupportedDataTypeException(type + " not supported");
        }
    }
}
