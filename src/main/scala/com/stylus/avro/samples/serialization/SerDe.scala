package com.stylus.avro.samples.serialization

import com.stylus.avro.samples.schema.{AvroSchema2, Schemas, SerDeSchema}

@SerialVersionUID(1L)
class SerDe[T >: Null](classPath : String) extends SerDeSchema[T] with Serializable {

  def deserialize(data : Array[Byte]) : T = getAvroSerDe().deserialize(data)

  def serialize(data : T) : Array[Byte] = getAvroSerDe().serialize(data)

  def dataType() : Class[T] = getAvroSerDe().dataType()

  private def getAvroSerDe() : AvroSchema2[T] = Schemas.getSchema(classPath).get.asInstanceOf[AvroSchema2[T]]

}
