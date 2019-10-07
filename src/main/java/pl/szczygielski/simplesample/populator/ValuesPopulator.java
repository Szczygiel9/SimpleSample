package pl.szczygielski.simplesample.populator;

import pl.szczygielski.simplesample.domain.ColumnType;

public interface ValuesPopulator {

    public String create(ColumnType type);

}
