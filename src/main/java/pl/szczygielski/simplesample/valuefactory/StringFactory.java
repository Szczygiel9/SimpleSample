package pl.szczygielski.simplesample.valuefactory;

import org.apache.commons.lang3.RandomStringUtils;

public class StringFactory {

    public String produce() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}
