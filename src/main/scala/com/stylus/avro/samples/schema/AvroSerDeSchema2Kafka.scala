package com.stylus.avro.samples.schema

import java.io.ByteArrayOutputStream
/*
import com.sksamuel.avro4s._
import org.apache.avro.Schema
import org.apache.kafka.common.serialization.{Deserializer, Serde, Serializer}

class AvroSerDeSchema2Kafka[T >: Null : SchemaFor : Encoder : Decoder] extends Serde[T] with Deserializer[T] with Serializer[T] with Serializable {

  val schema: Schema = AvroSchema[T]

  override def serializer(): Serializer[T] = this

  override def deserializer(): Deserializer[T] = this

  override def deserialize(topic: String, data: Array[Byte]): T = {
    if (data == null) null else {
      val input = AvroInputStream.binary[T].from(data).build(schema)
      input.iterator.next()
    }
  }

  override def close(): Unit = ()

  override def configure(configs: java.util.Map[String, _], isKey: Boolean): Unit = ()

  override def serialize(topic: String, data: T): Array[Byte] = {
    val baos = new ByteArrayOutputStream()
    val output = AvroOutputStream.binary[T].to(baos).build(schema)
    output.write(data)
    output.close()
    baos.toByteArray
  }
}
*/