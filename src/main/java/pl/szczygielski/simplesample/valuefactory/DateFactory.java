package pl.szczygielski.simplesample.valuefactory;

import org.apache.commons.lang3.RandomUtils;

public class DateFactory {

    public String produce() {
        final int day = RandomUtils.nextInt(1, 31);
        final int month = RandomUtils.nextInt(1, 12);
        final int year = RandomUtils.nextInt(1900, 2019);
        return day + "-" + month + "-" + year;
    }
}
