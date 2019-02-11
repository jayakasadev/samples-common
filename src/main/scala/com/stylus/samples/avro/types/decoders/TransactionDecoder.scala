package com.stylus.samples.avro.types.decoders


import com.sksamuel.avro4s.Decoder
import com.stylus.samples.avro.types.Transaction
import org.apache.avro.Schema

object TransactionDecoder extends Decoder[Transaction]{
  override def decode(value: Any, schema: Schema): Transaction = ???
}
