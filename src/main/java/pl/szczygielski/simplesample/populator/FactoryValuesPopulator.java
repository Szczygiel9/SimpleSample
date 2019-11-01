package pl.szczygielski.simplesample.populator;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.domain.ColumnType;
import pl.szczygielski.simplesample.valuefactory.*;

import javax.activation.UnsupportedDataTypeException;

@Component
@Profile("dev")
public class FactoryValuesPopulator implements ValuesPopulator {

    @SneakyThrows
    public String create(ColumnType type) {
        switch (type) {
            case BOOL:
                return new BooleanFactory().produce();
            case DATE:
                return new DateFactory().produce();
            case FLOAT:
                return new FloatFactory().produce();
            case INTEGER:
                return new IntegerFactory().produce();
            case VARCHAR:
                return new StringFactory().produce();
            default:
                throw new UnsupportedDataTypeException(type + " not supported");
        }
    }
}
