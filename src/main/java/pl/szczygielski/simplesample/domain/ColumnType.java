package pl.szczygielski.simplesample.domain;

import pl.szczygielski.simplesample.randomvaluesfactory.*;

import java.util.function.Supplier;

public enum ColumnType {

    VARCHAR(StringFactory::new),
    BOOL(BooleanFactory::new),
    INTEGER(IntegerFactory::new),
    FLOAT(FloatFactory::new),
    DATE(DateFactory::new);

    private final Supplier<DatatypeValueFactory> dataFactorySupplier;

    ColumnType(Supplier<DatatypeValueFactory> dataFactorySupplier) {
        this.dataFactorySupplier = dataFactorySupplier;
    }

    public String produceValue() {
        return this.dataFactorySupplier.get().produce();
    }
}
