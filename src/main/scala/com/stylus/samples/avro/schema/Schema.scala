package com.stylus.samples.avro.schema

trait SerDeSchema[T] {

  def deserialize(data : Array[Byte]) : T

  def serialize(data : T) : Array[Byte]

  def dataType() : Class[T]
}

trait AvroSchema[T] extends SerDeSchema[T] {
  def generateSchema(pretty : Boolean = false) : String
}