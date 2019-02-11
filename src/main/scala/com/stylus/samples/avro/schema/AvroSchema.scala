package com.stylus.samples.avro.schema

/*
//v1.6.4
import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import com.sksamuel.avro4s._
class AvroSerDeSchema[T](avroType : Class[T], schemaFor: SchemaFor[T], toRecord: ToRecord[T], fromRecord: FromRecord[T], decoder : Decoder[T], encoder : Encoder[T]) extends SerDeSchema[T]{

// class AvroSerDeSchema[T](avroType : Class[T], schemaFor: SchemaFor[T], toRecord: ToRecord[T], fromRecord: FromRecord[T]) extends SerDeSchema[T]{

  // cannot be used in multi threaded
  // private val byteStream : ByteArrayOutputStream = new ByteArrayOutputStream()

  private lazy val schema = AvroSchema[T](schemaFor)

  override def deserialize(data: Array[Byte]): T = {
    try{
      // cannot be reused due to concurrency issues
      val in = new ByteArrayInputStream(data)
      val is = AvroInputStream.data[T](data)(schemaFor, fromRecord)
      is.iterator.next()
    } catch {
      case e : Exception => throw new RuntimeException(e)
    }

  }

  override def serialize(data: T): Array[Byte] = {
    try{
      // cannot be reused due to concurrency issues
      val byteStream : ByteArrayOutputStream = new ByteArrayOutputStream()
      val os = AvroOutputStream.data[T](byteStream)(schemaFor, toRecord)
      os.write(data)
      os.flush()
      os.close()
      byteStream.toByteArray
    } catch {
      case e : Exception => throw new RuntimeException(e)
    } finally {
      //make the byte stream reusable
      // byteStream.reset()
    }
  }

  override def dataType(): Class[T] = avroType

  // def generateSchema(pretty : Boolean = false) : String = schemaFor.apply().toString(pretty)

  // v2.0.4
  def generateSchema(pretty : Boolean = false) : String = schema.toString(pretty)
}
*/