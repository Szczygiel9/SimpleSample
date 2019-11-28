package pl.szczygielski.simplesample.valuefactory;

import java.util.Random;

public class BooleanFactory implements DatatypeValueFactory {

    @Override
    public String produce() {
        final Random random = new Random();
        return Boolean.toString(random.nextBoolean());
    }
}
