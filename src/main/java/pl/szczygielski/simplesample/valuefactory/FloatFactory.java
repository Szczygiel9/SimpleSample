package pl.szczygielski.simplesample.valuefactory;

import java.util.Random;

public class FloatFactory {
    public String produce() {
        final Random random = new Random();
        final int multiplier = random.nextInt();
        return Float.toString(random.nextFloat() * multiplier);
    }
}
