package pl.szczygielski.simplesample.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ColumnTypeTest {

    @Test
    void testStringProduction() {
        final String producedString = ColumnType.VARCHAR.produceValue();
    }

    @Test
    void testBooleanProduction() {
        final String producedBool = ColumnType.BOOL.produceValue();
        Assert.assertTrue(producedBool.equals("true") || producedBool.equals("false"));
    }

    @Test
    void testIntegerProduction() {
        final String producedInt = ColumnType.INTEGER.produceValue();
        final float parsedInt = Integer.parseInt(producedInt);
    }

    @Test
    void testFloatProduction() {
        final String producedFloat = ColumnType.FLOAT.produceValue();
        final float parsedFloat = Float.parseFloat(producedFloat);
    }

    @Test
    void testDateProduction() throws ParseException {
        final String producedDate = ColumnType.DATE.produceValue().replaceAll("\"", "");
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
        final Date parsedDate = simpleDateFormat.parse(producedDate);
    }
}
