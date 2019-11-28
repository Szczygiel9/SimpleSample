package pl.szczygielski.simplesample.valuefactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.util.Strings;

public class StringFactory implements DatatypeValueFactory {

    public String produce() {
        final String randomString = RandomStringUtils.randomAlphabetic(10);
        return Strings.dquote(randomString);
    }
}
