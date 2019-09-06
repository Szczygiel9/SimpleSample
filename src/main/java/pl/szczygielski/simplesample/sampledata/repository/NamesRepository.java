package pl.szczygielski.simplesample.sampledata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.szczygielski.simplesample.sampledata.domain.Name;

@Repository
public interface NamesRepository extends MongoRepository<Name, String> {
}
