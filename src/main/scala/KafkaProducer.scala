import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object KafkaProducer extends App {

  var topicName = "simpleProducer"
  var key = "key1"
  var value = "value1"

  var props = new Properties()

  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer",
    "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer",
    "org.apache.kafka.common.serialization.StringDeserializer")

  val producer = new KafkaProducer[String, String](props)

  for (i <- 1 to 10) {
    val record = new ProducerRecord(topicName, key, value + s"$i")
    producer.send(record)
  }

  val record = new ProducerRecord(topicName, key, "the end " + new java.util.Date)

  producer.send(record)
  producer.close()

}
