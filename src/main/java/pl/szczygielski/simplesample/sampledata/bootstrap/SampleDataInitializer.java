package pl.szczygielski.simplesample.sampledata.bootstrap;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class SampleDataInitializer<T> {

    protected MongoRepository repository;

    protected abstract String getFileName();

    public SampleDataInitializer(MongoRepository repository) {
        this.repository = repository;
    }

    public void initData() {
        String fileName = getFileName();

        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource(fileName).getFile();

        File file = new File(fileName);

        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.lines().map(this::createInstance).forEach(repository::save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract T createInstance(String value);
}
