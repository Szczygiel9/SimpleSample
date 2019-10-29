package pl.szczygielski.simplesample.valuefactory;

import java.util.Random;

public class IntegerFactory {
    public String produce() {
        final Random random = new Random();
        return Integer.toString(random.nextInt());
    }
}
