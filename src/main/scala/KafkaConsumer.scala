import java.util.Properties

import org.apache.kafka.clients.consumer.KafkaConsumer
import scala.collection.JavaConverters._


object KafkaConsumer extends App {

  var topicName = "simpleProducer"
  var key = "key1"
  var value = "value1"

  var props = new Properties()

  props.put("bootstrap.servers", "localhost:9092")

  props.put("key.deserializer",
    "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer",
    "org.apache.kafka.common.serialization.StringDeserializer")

  //disable auto commit
  props.put("enable.auto.commit", "false")
  // props.put("auto.commit.interval.ms", "1000")
  // props.put("session.timeout.ms", "30000")
  //consumer group
  props.put("group.id", "ConsumerGroup1")

  val consumer = new KafkaConsumer[String, String](props)

  consumer.subscribe(java.util.Collections.singletonList(topicName))

  while (true) {
    val record = consumer.poll(100L)
    for (record <- record.asScala) {
      println(record)
    }
  }

}
