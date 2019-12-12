package pl.szczygielski.simplesample;

import pl.szczygielski.simplesample.predictedvaluesfactory.PredictedValuesFactory;

public class TestPredictedValuesFactory implements PredictedValuesFactory {

    @Override
    public String getCity() {
        return "Warsaw";
    }

    @Override
    public String getName() {
        return "Anna";
    }

    @Override
    public String getCompany() {
        return "Apple";
    }

    @Override
    public String getPostalCode() {
        return "23480";
    }

    @Override
    public String getSecondName() {
        return "Smith";
    }

    @Override
    public String getStreet() {
        return "Bakers street";
    }
}
