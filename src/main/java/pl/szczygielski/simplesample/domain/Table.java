package pl.szczygielski.simplesample.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Table {

    private String tableName;
    private List<Column> columns;
}
