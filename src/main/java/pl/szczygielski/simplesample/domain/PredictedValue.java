package pl.szczygielski.simplesample.domain;

import pl.szczygielski.simplesample.predictedvaluesfactory.PredictedValuesFactory;

import java.util.function.Function;

public enum PredictedValue {
    CITY(PredictedValuesFactory::getCity),
    NAME(PredictedValuesFactory::getName),
    COMPANY(PredictedValuesFactory::getCompany),
    POSTAL_CODE(PredictedValuesFactory::getPostalCode),
    SECOND_NAME(PredictedValuesFactory::getSecondName),
    STREET(PredictedValuesFactory::getStreet);

    private final Function<PredictedValuesFactory, String> predictedValuesFactoryFunction;

    PredictedValue(Function<PredictedValuesFactory, String> predictedValuesFactoryFunction) {
        this.predictedValuesFactoryFunction = predictedValuesFactoryFunction;
    }

    public String produceValue(PredictedValuesFactory predictedValuesFactory) {
        return this.predictedValuesFactoryFunction.apply(predictedValuesFactory);
    }

}
