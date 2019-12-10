package pl.szczygielski.simplesample.predictedvaluesfactory;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.stereotype.Component;
import pl.szczygielski.simplesample.sampledata.domain.Name;

@Component
public class DBPredictedValuesFactory implements PredictedValuesFactory {

    private MongoTemplate mongoTemplate;


    public DBPredictedValuesFactory(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public String getCity() {
        return null;
    }

    @Override
    public String getName() {
        return getEntityValue("name", Name.class);
    }

    @Override
    public String getCompany() {
        return null;
    }

    @Override
    public String getPostalCode() {
        return null;
    }

    @Override
    public String getSecondName() {
        return null;
    }

    @Override
    public String getStreet() {
        return null;
    }

    private String getEntityValue(String collectionName, Class<Name> outputType) {
        SampleOperation matchStage = Aggregation.sample(1);
        Aggregation aggregation = Aggregation.newAggregation(matchStage);
        final AggregationResults<Name> name = mongoTemplate.aggregate(aggregation, collectionName, outputType);
        return name.getUniqueMappedResult().getValue();
    }
}
