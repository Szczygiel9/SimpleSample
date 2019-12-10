package pl.szczygielski.simplesample.valuesprovider;

import pl.szczygielski.simplesample.domain.ColumnType;
import pl.szczygielski.simplesample.domain.PredictedValue;

public interface ValuesProvider {

    String getValue(ColumnType columnType, PredictedValue predictedValue);

}
