package pl.szczygielski.simplesample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.szczygielski.simplesample.domain.ColumnType;

public interface SupportedTypesRepository extends MongoRepository<String, ColumnType> {
}
