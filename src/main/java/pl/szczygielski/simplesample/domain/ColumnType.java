package pl.szczygielski.simplesample.domain;

import pl.szczygielski.simplesample.valuefactory.*;

public enum ColumnType {
    //TODO find better way of creating factories here
    VARCHAR(new StringFactory()),
    BOOL(new BooleanFactory()),
    INTEGER(new IntegerFactory()),
    FLOAT(new FloatFactory()),
    DATE(new DateFactory());

    private DatatypeValueFactory valueFactory;

    ColumnType(DatatypeValueFactory factory) {
        this.valueFactory = factory;
    }

    public String produceValue() {
        return this.valueFactory.produce();
    }
}
