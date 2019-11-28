package pl.szczygielski.simplesample.valuefactory;

import org.apache.commons.lang3.RandomUtils;
import org.apache.logging.log4j.util.Strings;

public class DateFactory implements DatatypeValueFactory {

    public String produce() {
        final int day = RandomUtils.nextInt(1, 31);
        final int month = RandomUtils.nextInt(1, 12);
        final int year = RandomUtils.nextInt(1900, 2019);
        final String resultDate = day + "-" + month + "-" + year;
        return Strings.dquote(resultDate);
    }
}
