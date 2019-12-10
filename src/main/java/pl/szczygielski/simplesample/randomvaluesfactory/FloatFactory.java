package pl.szczygielski.simplesample.randomvaluesfactory;

import java.util.Random;

public class FloatFactory implements DatatypeValueFactory {
    public String produce() {
        final Random random = new Random();
        final int multiplier = random.nextInt();
        return Float.toString(random.nextFloat() * multiplier);
    }
}
