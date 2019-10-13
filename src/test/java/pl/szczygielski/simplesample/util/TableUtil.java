package pl.szczygielski.simplesample.util;

import pl.szczygielski.simplesample.domain.ColumnType;
import pl.szczygielski.simplesample.domain.Table;

public class TableUtil {
    static public Table createSingleTypeTable(ColumnType type) {
        return new Table("sample-table")
                .withColumn("sample-column1", type)
                .withColumn("sample-column2", type)
                .withColumn("sample-column3", type)
                .withColumn("sample-column4", type);
    }

}
