# event_bus
Microservice with event bus pattern and SQRS

Docker compose
run kafka and zookper with:  docker-compse up -d

# Create Kafka Topic:
Once the Kafka and Zookeeper containers are running, you can create a Kafka topic. Use the following command to access the Kafka container and create the topic:
docker-compose exec kafka kafka-topics.sh --create --topic order-events --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

# Verify the Topic Creation
To verify that the topic has been created, you can list all topics with the following command:
docker-compose exec kafka kafka-topics.sh --list --bootstrap-server localhost:9092
