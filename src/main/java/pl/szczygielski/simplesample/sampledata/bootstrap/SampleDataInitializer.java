package pl.szczygielski.simplesample.sampledata.bootstrap;

import lombok.SneakyThrows;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class SampleDataInitializer<T> {

    private MongoRepository repository;

    public SampleDataInitializer(MongoRepository repository) {
        this.repository = repository;
    }

    @SneakyThrows
    public void initData() {
        String fileName = getFileName();

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        final Resource resource = resourceLoader.getResource("classpath:" + fileName);
        final File file = resource.getFile();

        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.lines().map(this::createInstance).forEach(repository::save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract String getFileName();

    protected abstract T createInstance(String value);
}
