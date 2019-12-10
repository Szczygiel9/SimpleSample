package pl.szczygielski.simplesample.valuesprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.domain.ColumnType;
import pl.szczygielski.simplesample.domain.PredictedValue;
import pl.szczygielski.simplesample.predictedvaluesfactory.PredictedValuesFactory;

@Component
public class RandomOrPredictedValuesProvider implements ValuesProvider {

    private PredictedValuesFactory predictedValuesFactory;

    @Autowired
    public RandomOrPredictedValuesProvider(PredictedValuesFactory predictedValuesFactory) {
        this.predictedValuesFactory = predictedValuesFactory;
    }

    @Override
    public String getValue(ColumnType columnType, PredictedValue predictedValue) {
        if (predictedValue != null) {
            return predictedValue.produceValue(predictedValuesFactory);
        } else {
            return columnType.produceValue();
        }
    }
}
