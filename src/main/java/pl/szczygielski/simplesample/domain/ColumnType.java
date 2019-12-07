package pl.szczygielski.simplesample.domain;

import pl.szczygielski.simplesample.valuefactory.*;

import java.util.function.Supplier;

public enum ColumnType {

    //TODO: still find better way of this. Do not depend on specific factories
    VARCHAR(() -> new StringFactory().produce()),
    BOOL(() -> new BooleanFactory().produce()),
    INTEGER(() -> new IntegerFactory().produce()),
    FLOAT(() -> new FloatFactory().produce()),
    DATE(() -> new DateFactory().produce());

    private Supplier<String> valueSupplier;

    ColumnType(Supplier<String> valueSupplier) {
        this.valueSupplier = valueSupplier;
    }

    public String produceValue() {
        return this.valueSupplier.get();
    }
}
