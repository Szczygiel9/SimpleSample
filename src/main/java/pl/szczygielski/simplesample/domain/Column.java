package pl.szczygielski.simplesample.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Column {
    private String name;
    private ColumnType type;
    private PredictedValue predictedValue;

    public Column(String name, ColumnType type, PredictedValue predictedValue) {
        this.name = name;
        this.type = type;
        this.predictedValue = predictedValue;
    }
}
