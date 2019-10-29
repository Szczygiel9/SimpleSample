package pl.szczygielski.simplesample.sampledata.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.sampledata.repository.NamesRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("Data-init")
public class StartupInitializer implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupInitializer.class);
    private List<SampleDataInitializer> initializers = new ArrayList<>();

    @Autowired
    public StartupInitializer(NamesRepository namesRepository) {
        initializers.add(new NamesInitializer(namesRepository));
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Running startup data initialization");
        initializers.forEach(SampleDataInitializer::initData);
        LOGGER.info("Data initialization done");
    }
}
