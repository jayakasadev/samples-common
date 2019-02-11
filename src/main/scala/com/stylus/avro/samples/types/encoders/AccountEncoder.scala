package com.stylus.avro.samples.types.encoders

import com.sksamuel.avro4s.Encoder
import com.stylus.avro.samples.types.Account
import org.apache.avro.Schema
import org.apache.avro.generic.GenericData

@Deprecated
object AccountEncoder extends Encoder[Account]{
  override def encode(account: Account, schema: Schema): AnyRef = {
    val record = new GenericData.Record(schema)
    record.put("bankId", account.bankId)
    record.put("accountNumber", account.accountNumber)
    record.put("dateCreated", account.dateCreated)
    record.put("balance", account.balance)
    record
  }
}
