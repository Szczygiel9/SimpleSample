package pl.szczygielski.simplesample.sampledata.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
public class Name {

    @Id
    private String id;
    private String value;

    public Name(final String value) {
        this.value = value;
    }
}
