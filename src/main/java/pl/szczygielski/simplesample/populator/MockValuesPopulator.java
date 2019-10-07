package pl.szczygielski.simplesample.populator;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.domain.ColumnType;

import javax.activation.UnsupportedDataTypeException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Component
public class MockValuesPopulator implements ValuesPopulator {

    @SneakyThrows
    public String create(ColumnType type) {
        switch (type) {
            case BOOL:
                return "true";
            case DATE:
                return new SimpleDateFormat("DD-MM-yyyy").format(Date.from(Instant.now()));
            case FLOAT:
                return "12.2";
            case INTEGER:
                return "16";
            case VARCHAR:
                return "MockVal";
            default:
                throw new UnsupportedDataTypeException(type + " not supported");
        }
    }
}
