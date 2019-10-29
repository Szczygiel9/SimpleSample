package pl.szczygielski.simplesample.valuefactory;

import java.util.Random;

public class BooleanFactory {

    public String produce() {
        final Random random = new Random();
        return Boolean.toString(random.nextBoolean());
    }
}
