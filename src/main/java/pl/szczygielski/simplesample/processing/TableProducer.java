package pl.szczygielski.simplesample.processing;

import pl.szczygielski.simplesample.domain.Table;
import pl.szczygielski.simplesample.request.TableProcessesRequestBody;

public interface TableProducer {

    String process(TableProcessesRequestBody requestBody);
}
