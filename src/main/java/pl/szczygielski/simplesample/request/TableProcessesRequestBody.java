package pl.szczygielski.simplesample.request;

import lombok.Getter;
import pl.szczygielski.simplesample.domain.Table;

@Getter
public class TableProcessesRequestBody {
    private Table table;
    private int rowsToProduce;

    public TableProcessesRequestBody(Table table, int rowsToProduce) {
        this.table = table;
        this.rowsToProduce = rowsToProduce;
    }
}
