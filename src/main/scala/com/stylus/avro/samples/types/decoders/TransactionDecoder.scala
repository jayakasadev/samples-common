package com.stylus.avro.samples.types.decoders

import com.sksamuel.avro4s.Decoder
import com.stylus.avro.samples.types.Transaction
import org.apache.avro.Schema

@Deprecated
object TransactionDecoder extends Decoder[Transaction]{
  override def decode(value: Any, schema: Schema): Transaction = ???
}
