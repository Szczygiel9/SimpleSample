package pl.szczygielski.simplesample.randomvaluesfactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerFactoryTest {

    private DatatypeValueFactory factory;

    @BeforeEach
    void setUp() {
        factory = new IntegerFactory();
    }

    @Test
    void testIntegerProduction() {
        final String producedInt = factory.produce();
        final int parsedInteger = Integer.parseInt(producedInt);
    }
}
