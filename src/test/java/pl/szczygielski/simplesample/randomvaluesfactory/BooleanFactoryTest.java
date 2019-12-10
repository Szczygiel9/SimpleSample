package pl.szczygielski.simplesample.randomvaluesfactory;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BooleanFactoryTest {
    private DatatypeValueFactory factory;

    @BeforeEach
    void setUp() {
        factory = new BooleanFactory();
    }

    @Test
    void testBooleanProduction() {
        final String producedValue = factory.produce();
        Assert.assertTrue(producedValue.equals("true") || producedValue.equals("false"));
    }
}
