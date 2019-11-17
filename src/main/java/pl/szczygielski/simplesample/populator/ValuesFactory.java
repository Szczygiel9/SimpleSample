package pl.szczygielski.simplesample.populator;

import pl.szczygielski.simplesample.domain.ColumnType;

public interface ValuesFactory {

    public String create(ColumnType type);

}
