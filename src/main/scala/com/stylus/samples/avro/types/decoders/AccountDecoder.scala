package com.stylus.samples.avro.types.decoders


import com.sksamuel.avro4s.Decoder
import com.stylus.samples.avro.types.Account
import org.apache.avro.Schema
import org.apache.avro.generic.GenericRecord

object AccountDecoder extends Decoder[Account] {
  override def decode(value: Any, schema: Schema): Account = {
    val record = value.asInstanceOf[GenericRecord]
    Account(record.get("bankId").toString, record.get("accountNumber").toString, record.get("dateCreated").toString, record.get("balance").asInstanceOf[Long])
  }
}