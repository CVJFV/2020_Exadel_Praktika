package practice.guestregistry.data.mongo.listeners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import practice.guestregistry.data.mongo.entities.WorkerEntity;

@Component
public class CascadeSaveMongoEventListener extends AbstractMongoEventListener<WorkerEntity> {

    private final MongoTemplate mongoTemplate;
    private static int counter = -1;

    @Autowired
    public CascadeSaveMongoEventListener(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


//public void onBeforeConvert(final BeforeConvertEvent<Worker> event) {
    @Override
    public void onBeforeSave(final BeforeSaveEvent<WorkerEntity> event) {
//        ... does some auditing manipulation, set timestamps, whatever ...
        final Object source = event.getSource();
//        System.out.println("im here event:" + event);
        ReflectionUtils.doWithFields(source.getClass(), new CascadeCallback(source, mongoTemplate, ++counter));
    }
}
