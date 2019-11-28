package pl.szczygielski.simplesample.valuefactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FloatFactoryTest {

    private DatatypeValueFactory factory;

    @BeforeEach
    void setUp() {
        factory = new FloatFactory();
    }

    @Test
    void testFloatProduction() {
        final String producedFloat = factory.produce();
        final float parsedFloat = Float.parseFloat(producedFloat);
    }
}
