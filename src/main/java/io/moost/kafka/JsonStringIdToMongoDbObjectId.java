package io.moost.kafka;

import com.mongodb.kafka.connect.sink.MongoSinkTopicConfig;
import com.mongodb.kafka.connect.sink.converter.SinkDocument;
import com.mongodb.kafka.connect.sink.processor.PostProcessor;
import org.apache.kafka.connect.sink.SinkRecord;


public class JsonStringIdToMongoDbObjectId extends PostProcessor {
    public JsonStringIdToMongoDbObjectId(MongoSinkTopicConfig config) {
        super(config);
    }

    @Override
    public void process(SinkDocument doc, SinkRecord orig) {
        doc.getValueDoc().ifPresent(vd ->
                vd.append("_id", vd.getString("id").asObjectId())
        );
    }
}
