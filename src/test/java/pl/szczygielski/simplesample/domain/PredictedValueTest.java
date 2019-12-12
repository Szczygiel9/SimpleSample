package pl.szczygielski.simplesample.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.szczygielski.simplesample.TestPredictedValuesFactory;
import pl.szczygielski.simplesample.predictedvaluesfactory.PredictedValuesFactory;

import static org.junit.jupiter.api.Assertions.*;

class PredictedValueTest {

    private PredictedValuesFactory predictedValuesFactory;

    @BeforeEach
    void setUp() {
        predictedValuesFactory = new TestPredictedValuesFactory();
    }

    @Test
    void testCityProduction() {
        final String producedValue = PredictedValue.CITY.produceValue(predictedValuesFactory);
        assertEquals("Warsaw", producedValue);
    }

    @Test
    void testNameProduction() {
        final String producedValue = PredictedValue.NAME.produceValue(predictedValuesFactory);
        assertEquals("Anna", producedValue);
    }

    @Test
    void testCompanyProduction() {
        final String producedValue = PredictedValue.COMPANY.produceValue(predictedValuesFactory);
        assertEquals("Apple", producedValue);
    }

    @Test
    void testPostalCodeProduction() {
        final String producedValue = PredictedValue.POSTAL_CODE.produceValue(predictedValuesFactory);
        assertEquals("23480", producedValue);
    }

    @Test
    void testSecondNameProduction() {
        final String producedValue = PredictedValue.SECOND_NAME.produceValue(predictedValuesFactory);
        assertEquals("Smith", producedValue);
    }

    @Test
    void testStreetProduction() {
        final String producedValue = PredictedValue.STREET.produceValue(predictedValuesFactory);
        assertEquals("Bakers street", producedValue);
    }
}
