package pl.szczygielski.simplesample.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Table {

    private String tableName;
    private List<Column> columns;

    public Table(String tableName) {
        this.tableName = tableName;
        columns = new ArrayList<>();
    }

    public Table(String tableName, List<Column> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    public Table withColumn(String name, ColumnType type) {
        Column column = Column.builder()
                .name(name)
                .type(type)
                .build();
        columns.add(column);
        return this;
    }

    public List<String> getColumnsNames() {
        return this.columns
                .stream()
                .map(Column::getName)
                .collect(Collectors.toList());
    }

    public List<ColumnType> getColumnsTypes() {
        return this.columns
                .stream()
                .map(Column::getType)
                .collect(Collectors.toList());
    }
}
