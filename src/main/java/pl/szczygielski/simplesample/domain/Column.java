package pl.szczygielski.simplesample.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Column {
    private String name;
    private ColumnType type;

    public Column(String name, ColumnType type) {
        this.name = name;
        this.type = type;
    }
}
