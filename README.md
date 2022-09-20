# Kafka Connect Post Processor
This repository provides a Kafka Connect Post Processor which does one simple thing.
It checks the incoming JSON String for a field with name id and type String transforms the value into an ObjectId
and uses this ObjectId for the "_id" field.
