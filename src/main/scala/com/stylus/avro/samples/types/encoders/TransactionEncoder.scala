package com.stylus.avro.samples.types.encoders

import com.sksamuel.avro4s.Encoder
import com.stylus.avro.samples.types.Transaction
import org.apache.avro.Schema

@Deprecated
object TransactionEncoder extends Encoder[Transaction]{
  override def encode(t: Transaction, schema: Schema): AnyRef = ???
}
