package pl.szczygielski.simplesample.sampledata.bootstrap;

import pl.szczygielski.simplesample.sampledata.domain.Name;
import pl.szczygielski.simplesample.sampledata.repository.NamesRepository;

public class NamesInitializer extends SampleDataInitializer<Name> {

    public NamesInitializer(NamesRepository repository) {
        super(repository);
    }

    @Override
    protected String getFileName() {
        return "names.txt";
    }

    @Override
    protected Name createInstance(String value) {
        return new Name(value);
    }

}
