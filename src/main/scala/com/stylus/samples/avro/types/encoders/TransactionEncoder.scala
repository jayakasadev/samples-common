package com.stylus.samples.avro.types.encoders

import com.sksamuel.avro4s.Encoder
import com.stylus.samples.avro.types.Transaction
import org.apache.avro.Schema

object TransactionEncoder extends Encoder[Transaction]{
  override def encode(t: Transaction, schema: Schema): AnyRef = ???
}
