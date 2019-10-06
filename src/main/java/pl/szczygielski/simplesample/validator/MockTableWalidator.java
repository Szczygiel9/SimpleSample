package pl.szczygielski.simplesample.validator;

import java.util.ArrayList;
import java.util.List;

public class MockTableWalidator implements TableValidador {

    @Override
    public List<String> validate() {
        return new ArrayList<>();
    }
}
