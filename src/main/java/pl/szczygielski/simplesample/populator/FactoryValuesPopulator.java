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
                final String producedDate = new DateFactory().produce();
                return surroundWithQuotationMarks(producedDate);
            case FLOAT:
                return new FloatFactory().produce();
            case INTEGER:
                return new IntegerFactory().produce();
            case VARCHAR:
                final String producedString = new StringFactory().produce();
                return surroundWithQuotationMarks(producedString);
            default:
                throw new UnsupportedDataTypeException(type + " not supported");
        }
    }

    private String surroundWithQuotationMarks(String producedValue) {
        return "\"" + producedValue + "\"";
    }
}
