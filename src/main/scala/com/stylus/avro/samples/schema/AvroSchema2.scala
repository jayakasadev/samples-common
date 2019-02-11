package com.stylus.avro.samples.schema

import java.io.ByteArrayOutputStream

import com.sksamuel.avro4s._
import org.apache.avro.Schema

class AvroSchema2 [T >: Null : SchemaFor : Encoder : Decoder](avroType : Class[T]) extends AvroSchema[T] { //de[T] with Deserializer[T] with Serializer[T] with Serializable{

  private lazy val schema : Schema = AvroSchema[T]

  override def serialize(data: T): Array[Byte] = {
    val byteStream = new ByteArrayOutputStream()
    val output = AvroOutputStream.binary[T].to(byteStream).build(schema)
    output.write(data)
    output.close()
    byteStream.toByteArray
  }

  override def deserialize(data: Array[Byte]): T = {
    if (data == null) null else {
      val input = AvroInputStream.binary[T].from(data).build(schema)
      input.iterator.next()
    }
  }

  override def dataType(): Class[T] = avroType

  def generateSchema(pretty : Boolean = false) : String = schema.toString(pretty)
}
