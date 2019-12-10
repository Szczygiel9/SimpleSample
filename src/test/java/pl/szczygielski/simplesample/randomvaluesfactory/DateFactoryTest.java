package pl.szczygielski.simplesample.randomvaluesfactory;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateFactoryTest {

    private DatatypeValueFactory factory;

    @BeforeEach
    void setUp() {
        factory = new DateFactory();
    }

    @Test
    @SneakyThrows
    void testDateProduction() {
        final String producedDate = factory.produce().replaceAll("\"", "");
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
        final Date parsedDate = simpleDateFormat.parse(producedDate);
    }
}
