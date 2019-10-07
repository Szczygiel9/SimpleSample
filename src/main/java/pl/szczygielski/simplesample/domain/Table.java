package pl.szczygielski.simplesample.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Table {

    private String tableName;
    private List<Column> columns;

    public Table(String tableName) {
        this.tableName = tableName;
        columns = new ArrayList<>();
    }

    public Table withColumn(String name, ColumnType type) {
        Column column = Column.builder()
                .name(name)
                .type(type)
                .build();
        columns.add(column);
        return this;
    }
}
